package hu.bme.aut.android.receptek.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DigestItem(

	@field:SerializedName("schemaOrgTag")
	val schemaOrgTag: String? = null,

	@field:SerializedName("sub")
	val sub: ArrayList<Sub?>? = null,

	@field:SerializedName("total")
	val total: Double? = null,

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("daily")
	val daily: Double? = null,

	@field:SerializedName("hasRDI")
	val hasRDI: Boolean? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null
): Serializable