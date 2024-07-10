package com.route.routetask.data.data_models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReviewsItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("reviewerName")
	val reviewerName: String? = null,

	@field:SerializedName("reviewerEmail")
	val reviewerEmail: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("comment")
	val comment: String? = null
) : Parcelable