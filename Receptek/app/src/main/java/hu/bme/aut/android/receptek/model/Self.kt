package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName

data class Self(

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)