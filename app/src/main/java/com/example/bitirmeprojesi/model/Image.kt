package com.example.bitirmeprojesi.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val height:Int,
    val url:String,
    val width:Int
):Parcelable
