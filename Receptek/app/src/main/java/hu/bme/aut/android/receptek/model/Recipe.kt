package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Recipe(

	@field:SerializedName("shareAs")
	val shareAs: String? = null,

	@field:SerializedName("instructions")
	val instructions: List<String?>? = null,

	@field:SerializedName("co2EmissionsClass")
	val co2EmissionsClass: String? = null,

	@field:SerializedName("mealType")
	val mealType: List<String?>? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("totalCO2Emissions")
	val totalCO2Emissions: Double? = null,

	@field:SerializedName("cuisineType")
	val cuisineType: List<String?>? = null,

	@field:SerializedName("totalNutrients")
	val totalNutrients: TotalNutrients? = null,

	@field:SerializedName("yield")
	val yield: Double? = null,

	@field:SerializedName("digest")
	val digest: List<DigestItem?>? = null,

	@field:SerializedName("ingredients")
	val ingredients: List<IngredientsItem?>? = null,

	@field:SerializedName("totalDaily")
	val totalDaily: TotalDaily? = null,

	@field:SerializedName("ingredientLines")
	val ingredientLines: List<String?>? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("cautions")
	val cautions: List<String?>? = null,

	@field:SerializedName("healthLabels")
	val healthLabels: List<String?>? = null,

	@field:SerializedName("externalId")
	val externalId: String? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("calories")
	val calories: Double? = null,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("dietLabels")
	val dietLabels: List<String?>? = null,

	@field:SerializedName("dishType")
	val dishType: List<String?>? = null,

	@field:SerializedName("totalWeight")
	val totalWeight: Double? = null,

	@field:SerializedName("glycemicIndex")
	val glycemicIndex: Double? = null
): Serializable