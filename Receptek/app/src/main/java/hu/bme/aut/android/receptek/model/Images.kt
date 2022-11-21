package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Images(

	@field:SerializedName("REGULAR")
	val rEGULAR: REGULAR? = null,

	@field:SerializedName("SMALL")
	val sMALL: SMALL? = null,

	@field:SerializedName("LARGE")
	val lARGE: LARGE? = null,

	@field:SerializedName("THUMBNAIL")
	val tHUMBNAIL: THUMBNAIL? = null
): Serializable