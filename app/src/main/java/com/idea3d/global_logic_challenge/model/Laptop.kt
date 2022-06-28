package com.idea3d.global_logic_challenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Laptop(
    @SerializedName("title")
    val title:String,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description:String
): Parcelable

@Parcelize
data class LaptopList(
    val laptopList: List<Laptop>
):Parcelable
