package com.route.routetask.ui.utils

import android.annotation.SuppressLint
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.route.routetask.data.data_models.ProductsItem
import com.squareup.picasso.Picasso

@BindingAdapter("android:imageURL")
fun loadImageToImageView(imageView: ImageView, url: String) {
    Picasso.get().load(url).into(imageView)
}

@BindingAdapter("android:setRating")
fun setRating(text: TextView, rating: Double) {
    text.text = "Rating ($rating)"
}

@SuppressLint("DefaultLocale")
@BindingAdapter("android:setPriceAfterDiscount")
fun setPriceAfterDiscount(text: TextView, product: ProductsItem) {
    val price: Double
    if (product.discountPercentage!! > 1.0) {
        val newDiscountPercentage = product.discountPercentage / 100
        price = product.price!! * newDiscountPercentage
    } else
        price = product.price!! * product.discountPercentage

    val formattedPrice = String.format("%.2f", price)
    text.text = "$formattedPrice EGP"
}

@BindingAdapter("android:setPriceBeforeDiscount")
fun setPriceBeforeDiscount(textView: TextView, price: Double) {
    val spannableString = SpannableString(price.toString())
    spannableString.setSpan(
        StrikethroughSpan(),
        0,
        spannableString.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    textView.text = spannableString
}