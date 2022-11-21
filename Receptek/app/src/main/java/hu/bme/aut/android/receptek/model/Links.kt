package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName

data class Links(

	@field:SerializedName("next")
	val next: Next? = null,

	@field:SerializedName("self")
	val self: Self? = null
)