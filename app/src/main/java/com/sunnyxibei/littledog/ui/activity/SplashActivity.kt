package com.sunnyxibei.littledog.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.viewpager2.widget.ViewPager2

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

    @Composable
    fun SplashWidget() {
        Surface(color = MaterialTheme.colors.background) {
           ViewPager2(this)
        }
    }

}