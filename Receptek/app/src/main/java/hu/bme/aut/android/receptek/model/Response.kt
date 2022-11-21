package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("hits")
	val hits: List<HitsItem?>? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("from")
	val from: Int? = null,

	@field:SerializedName("to")
	val to: Int? = null
)