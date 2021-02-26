package com.sunnyxibei.littledog.data

import androidx.annotation.DrawableRes

data class Dog(
    val name: String,
    val age: Int,
    val birthday: String,
    val city: String,
    val desc: String,
    @DrawableRes val avatar: Int,
    @DrawableRes val banner: Int,
    var adopted: Boolean = false,
)