package com.example.bitirmeprojesi.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TravelApi(
    val category: String,
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<Image>,
    val isBookMark: Boolean,
    val title: String
) : Parcelable
