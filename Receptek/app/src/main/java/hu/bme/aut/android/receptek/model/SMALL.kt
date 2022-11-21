package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SMALL(

	@field:SerializedName("width")
	val width: Double? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Double? = null
): Serializable