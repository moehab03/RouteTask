package com.route.routetask.data.data_models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("qrCode")
	val qrCode: String? = null,

	@field:SerializedName("barcode")
	val barcode: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
) : Parcelable