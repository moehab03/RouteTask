package com.route.routetask.data.data_models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dimensions(

	@field:SerializedName("depth")
	val depth: Double? = null,

	@field:SerializedName("width")
	val width: Double? = null,

	@field:SerializedName("height")
	val height: Double? = null
) : Parcelable