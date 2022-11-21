package hu.bme.aut.android.receptek.feature.receipt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.android.receptek.databinding.ActivityReceiptBinding
import hu.bme.aut.android.receptek.feature.details.ReceiptDetails
import hu.bme.aut.android.receptek.model.HitsItem
import hu.bme.aut.android.receptek.model.Recipe
import hu.bme.aut.android.receptek.model.Response
import hu.bme.aut.android.receptek.network.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import kotlin.concurrent.thread

class ReceiptActivity : AppCompatActivity(), ReceiptAdapter.OnReceiptSelectedListener,
    SearchRecipesDialogFragment.SendRequestListener {

    private lateinit var binding: ActivityReceiptBinding
    private lateinit var adapter: ReceiptAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFab()
        initRecyclerView()
    }

    fun initFab(){
        binding.fab.setOnClickListener{
            SearchRecipesDialogFragment().show(supportFragmentManager, SearchRecipesDialogFragment::class.java.simpleName)
        }
    }

    fun initRecyclerView(){
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ReceiptAdapter(this)
        binding.mainRecyclerView.adapter = adapter
    }

    override fun onReceiptSelected(receipt: Recipe?) {
        val showDetailsIntent = Intent()
        Log.d("selected", receipt.toString())
        showDetailsIntent.setClass(this@ReceiptActivity, ReceiptDetails::class.java)
        showDetailsIntent.putExtra( "RECIPE_EXTRA", receipt)
        startActivity(showDetailsIntent)
    }

    override fun onParametersAdded(searchword: String?, maxingr: Int?, mealtype: String?, health: List<String>?) {
        adapter.removeAll()
        var mt: String?
        mt = if(mealtype.equals("None")) null
        else mealtype
        var maximumingr: Int?
        if(maxingr == null) maximumingr = 200
        else maximumingr = maxingr
        Log.d("params", searchword.toString() + "  " + maxingr + "  " + mealtype + "  " + health)
        NetworkManager.getListofRecipes(searchword, maximumingr, mt, health)?.enqueue(object: Callback<Response?> {
            override fun onResponse(
                call: Call<Response?>,
                response: retrofit2.Response<Response?>
            ) {
                Log.d("yeee", "onResponse: " + response.message())
                if (response.isSuccessful) {
                    Log.d("yeee", "response.succesfull")
                    var fl: Response? = response.body()
                    var hs: List<HitsItem?>? = fl?.hits
                    if (hs != null) {
                        for (i in hs){
                            if (i != null) {
                                adapter.addRecipes(i.recipe)
                            }
                        }
                    }
                } else {
                    Log.d("yeee", "response.notsuccesfull")
                    Toast.makeText(this@ReceiptActivity, "Error: " + response.message().toString(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Response?>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }
        })
    }




}