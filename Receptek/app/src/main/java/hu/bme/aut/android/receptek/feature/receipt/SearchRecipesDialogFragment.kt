package hu.bme.aut.android.receptek.feature.receipt

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.anurag.multiselectionspinner.MultiSelectionSpinnerDialog
import com.anurag.multiselectionspinner.MultiSpinner
import hu.bme.aut.android.receptek.R
import hu.bme.aut.android.receptek.databinding.DialogSearchRecipesBinding
import java.lang.RuntimeException

//Multispinner doksi: https://github.com/AnuraganuPunalur/Multi-Selection-Spinner-Android

class SearchRecipesDialogFragment: AppCompatDialogFragment(),
 MultiSelectionSpinnerDialog.OnMultiSpinnerSelectionListener{

    private lateinit var binding: DialogSearchRecipesBinding
    private lateinit var listener: SendRequestListener

    private lateinit var spinnerContentList: MutableList<String>
    private lateinit var mySpinner: MultiSpinner
    private var health: List<String>? = null

    interface SendRequestListener{
        fun onParametersAdded(searchword: String?, maxingr: Int?, mealtype: String?, health: List<String>?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = DialogSearchRecipesBinding.inflate(LayoutInflater.from(context))

        listener = context as? SendRequestListener
            ?: throw RuntimeException("Activity must implement the SendRequestListener interface!")

    }

    fun initSpinner(){
        spinnerContentList = ArrayList()

        //health
        spinnerContentList.add("alcohol-free")
        spinnerContentList.add("celery-free")
        spinnerContentList.add("crustacean-free")
        spinnerContentList.add("dairy-free")
        spinnerContentList.add("egg-free")
        spinnerContentList.add("fish-free")
        spinnerContentList.add("foodmap-free")
        spinnerContentList.add("gluten-free")
        spinnerContentList.add("soy-free")
        spinnerContentList.add("sulfite-free")
        spinnerContentList.add("sesame-free")
        spinnerContentList.add("shellfish-free")
        spinnerContentList.add("pork-free")
        spinnerContentList.add("wheat-free")
        spinnerContentList.add("lupine-free")
        spinnerContentList.add("mollusk-free")
        spinnerContentList.add("mustard-free")
        spinnerContentList.add("kidney-friendly")
        spinnerContentList.add("low-fat-abs")
        spinnerContentList.add("low-sugar")
        spinnerContentList.add("paleo")

        //diet
        //spinnerContentList.add("balanced")
        //spinnerContentList.add("high-fiber")
        //spinnerContentList.add("high-protein")
        //spinnerContentList.add("low-carb")
        //spinnerContentList.add("low-fat")
        //spinnerContentList.add("low-sodium")

        //Cuisine
        //spinnerContentList.add("American")
        //spinnerContentList.add("Asian")
        //spinnerContentList.add("British")
        //spinnerContentList.add("Caribbean")
        //spinnerContentList.add("Central Europe")
        //spinnerContentList.add("Chinese")
        //spinnerContentList.add("Eastern Europe")
        //spinnerContentList.add("French")
        //spinnerContentList.add("Indian")
        //spinnerContentList.add("Italian")
        //spinnerContentList.add("Japanese")
        //spinnerContentList.add("Mexican")
        //spinnerContentList.add("Middle Eastern")
        //spinnerContentList.add("Nordic")
        //spinnerContentList.add("South East Asian")
        //spinnerContentList.add("South American")

        //dishtype
        //spinnerContentList.add("Biscuits and cookies")
        //spinnerContentList.add("Bread")
        //spinnerContentList.add("Cereals")
        //spinnerContentList.add("Condiments and sauces")
        //spinnerContentList.add("Desserts")
        //spinnerContentList.add("Drinks")
        //spinnerContentList.add("Main course")
        //spinnerContentList.add("Sandwiches")
        //spinnerContentList.add("Side dish")
        //spinnerContentList.add("Soup")
        //spinnerContentList.add("Starter")
        //spinnerContentList.add("Sweets")
        //spinnerContentList.add("Pancake")
        //spinnerContentList.add("Preps")
        //spinnerContentList.add("Preserve")
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogSearchRecipesBinding.inflate(LayoutInflater.from(context))

        initSpinner()
        
        mySpinner = binding.spinner
        mySpinner.setAdapterWithOutImage(this.context, spinnerContentList, this)
        mySpinner.initMultiSpinner(this.context, mySpinner)

        binding.spMealType.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.mealtype_category_items)
        )

        return AlertDialog.Builder(requireContext())
            .setTitle("New recipes")
            .setView(binding.root)
            .setPositiveButton("OK"){ _, _ ->
                if(binding.maxnumedittext.text.toString() == ""){
                    listener.onParametersAdded(
                        binding.SearchValue.text.toString(), null,
                        binding.spinner.text.toString(), health
                    )
                }else{
                    listener.onParametersAdded(
                        binding.SearchValue.text.toString(), Integer.parseInt(binding.maxnumedittext.text.toString())
                        , binding.spinner.text.toString(), health
                    )
                }

            }
            .setNegativeButton("Cancel", null)
            .create()
    }

    override fun OnMultiSpinnerItemSelected(chosenItems: MutableList<String>?) {
        for (i in chosenItems!!.indices){
            Log.e("chosenItems",chosenItems[i])
        }
        health = chosenItems
    }
}