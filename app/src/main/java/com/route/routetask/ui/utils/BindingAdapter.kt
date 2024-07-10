package com.route.routetask.ui.utils

import android.annotation.SuppressLint
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:imageURL")
fun loadImageToImageView(imageView: ImageView, url: String){
    Picasso.get().load(url).into(imageView)
}

@BindingAdapter("android:setRating")
fun setRating(text: TextView, rating: Double){
    text.text = "Rating ($rating)"
}

@SuppressLint("DefaultLocale")
@BindingAdapter("android:setPrice")
fun setPrice(text: TextView, price: Double){
    val formattedPrice = String.format("%.2f", price)
    text.text = "$formattedPrice EGP"
}

@BindingAdapter("android:setPriceBeforeDiscount")
fun setPriceBeforeDiscount(textView: TextView, price: Double){
    val spannableString = SpannableString(price.toString())
    spannableString.setSpan(StrikethroughSpan(), 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    textView.text = spannableString
}