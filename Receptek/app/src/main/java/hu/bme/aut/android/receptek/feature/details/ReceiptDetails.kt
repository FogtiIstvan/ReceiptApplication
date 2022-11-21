package hu.bme.aut.android.receptek.feature.details

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import hu.bme.aut.android.receptek.R
import hu.bme.aut.android.receptek.databinding.ActivityReceiptDetailsBinding
import hu.bme.aut.android.receptek.databinding.IngredientsListBinding
import hu.bme.aut.android.receptek.databinding.ItemReceiptBinding
import hu.bme.aut.android.receptek.model.IngredientsItem
import hu.bme.aut.android.receptek.model.Recipe

class ReceiptDetails : AppCompatActivity() {
    private lateinit var binding: ActivityReceiptDetailsBinding
    private lateinit var listBinding: IngredientsListBinding

    companion object {
        private lateinit var recipe: Recipe
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiptDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recipe = intent.getSerializableExtra("RECIPE_EXTRA") as Recipe



        initDetailsView()
    }

    @SuppressLint("SetTextI18n")
    fun initDetailsView(){
        //Recept címe
        binding.DetLabel.text = recipe.label

        //Kezdő kép betöltése
        Glide.with(this)
            .load(recipe.images?.lARGE?.url)
            .into(binding.topImage)

        //Hozzávaló lista betöltése
        binding.ingr.text = "Ingredients: "
        for(i in recipe?.ingredients!!){
            listBinding = IngredientsListBinding.inflate(layoutInflater)
            listBinding.textView.text = "   - " + i!!.text
            binding.listOfRows.addView(listBinding.root)
        }

        //Kalória betöltése
        binding.kcal.text = "     " + recipe.calories.toString()

        //Konyha betöltése
        if(recipe.cuisineType != null) {
            var ct = "      "

            for (i in recipe.cuisineType!!) {
                ct += i
                if(i != recipe.cuisineType!![recipe.cuisineType!!.size-1]) ct += ", "

            }
            binding.cuisinetype.text = ct
        }else {
            binding.cuisinetype.text = "     No infromation."
        }

        //Instrukciók betöltése
        Log.d("Instruction", recipe.instructions.toString())
        if(recipe.instructions == null){
            binding.instructions.text = "     No instructions found."
        }else{
            binding.instructions.text = "     " + recipe.instructions.toString()
        }


        binding.hyperLink.text = recipe.url
    }


}