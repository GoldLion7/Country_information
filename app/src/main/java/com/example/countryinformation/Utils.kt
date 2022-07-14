package com.example.countryinformation

import android.R.attr.value
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*


fun languagesToString(languages: List<Language>) : String {
//    var result = ""
//
//    for ((index, language) in languages.withIndex())
//        if (index != languages.lastIndex)
//            result += "${language.name}, "
//        else
//            result += language.name
//
//    return result

    return languages.joinToString {it.name}
}

fun formatNumber(number: Long) : String {
    val string = NumberFormat.getInstance().format(number)
    return string
}

fun loadImages (imageView: ImageView, url: String) {
    Picasso.get()
        .load(url)
        .into(imageView);
}

fun flagToString(flags: Flags) : String {


    return flags.png
}