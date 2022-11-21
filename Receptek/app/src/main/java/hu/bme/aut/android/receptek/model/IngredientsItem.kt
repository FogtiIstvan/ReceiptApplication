package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class IngredientsItem(

	@field:SerializedName("quantity")
	val quantity: Double? = null,

	@field:SerializedName("measure")
	val measure: String? = null,

	@field:SerializedName("foodId")
	val foodId: String? = null,

	@field:SerializedName("weight")
	val weight: Double? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("food")
	val food: String? = null
): Serializable