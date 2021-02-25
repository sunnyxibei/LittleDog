package com.sunnyxibei.littledog.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sunnyxibei.littledog.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashWidget()
        }
    }

    @Composable
    fun SplashWidget() {
        Surface(color = MaterialTheme.colors.background) {
            Image(
                painter = painterResource(id = R.drawable.img_dog_companion),
                contentDescription = "温柔的陪伴",
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(32.dp)) {
                Spacer(modifier = Modifier.height(42.dp))
                Text(
                    text = "find your dog",
                    style = TextStyle(color = Color.LightGray, fontSize = 24.sp),
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "find your companion",
                    style = TextStyle(color = Color.LightGray, fontSize = 24.sp),
                )
            }
        }
    }

}