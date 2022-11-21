package hu.bme.aut.android.receptek.feature.receipt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition
import hu.bme.aut.android.receptek.R
import hu.bme.aut.android.receptek.databinding.ItemReceiptBinding
import hu.bme.aut.android.receptek.model.HitsItem
import hu.bme.aut.android.receptek.model.Recipe

class ReceiptAdapter(private val listener: OnReceiptSelectedListener): RecyclerView.Adapter<ReceiptAdapter.ReceiptViewHolder>() {
    private val recipes: MutableList<Recipe> = ArrayList()

    interface OnReceiptSelectedListener{
        fun onReceiptSelected(receipt: Recipe?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceiptViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_receipt, parent, false)
        return ReceiptViewHolder(view)
    }

    inner class ReceiptViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        var binding = ItemReceiptBinding.bind(itemView)
        var item: Recipe? = null

        init{
            binding.root.setOnClickListener{listener.onReceiptSelected(item)}
        }

        fun bind(newreceipt: Recipe?){
            binding.ReceiptItemNameTextView.text = newreceipt!!.label
            item = newreceipt
            var c: String = "caution(s): "
            if(item!!.cautions!!.size != 0) {
                for (i in item!!.cautions!!) {
                    c += "$i"
                    if (i == item!!.cautions!![item!!.cautions!!.size - 1]) break
                    else c += ", "
                }
            }else c += "none"

            binding.ReceiptItemCautionTextView.text = c

            Glide.with(itemView.context)
                .load(item?.images?.rEGULAR?.url)
                .into(binding.ImageOfReceipt)
        }
    }

    override fun onBindViewHolder(holder: ReceiptViewHolder, position: Int) {
        val item = recipes[position]
        holder.bind(item)
    }

    fun addRecipes(recipe: Recipe?){
        recipes.add(recipe!!)
        notifyItemInserted(recipes.size - 1)
    }

    fun removeAll(){
        recipes.removeAll(recipes)
        Log.d("remove", recipes.size.toString())
    }

    override fun getItemCount(): Int =recipes.size
}