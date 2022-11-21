package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName

data class HitsItem(

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("recipe")
	val recipe: Recipe? = null
)