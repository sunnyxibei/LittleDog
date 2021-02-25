/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sunnyxibei.littledog.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.sunnyxibei.littledog.ui.Pager
import com.sunnyxibei.littledog.ui.PagerState
import com.sunnyxibei.littledog.ui.fragment.DogDetail
import com.sunnyxibei.littledog.ui.fragment.DogList
import com.sunnyxibei.littledog.ui.fragment.MyDogList
import com.sunnyxibei.littledog.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val viewModel: MainViewModel by viewModels()
        setContent {
            MyTheme {
                if (viewModel.currentDog != null) {
                    DogDetail()
                } else {
                    MainScreen()
                }
            }
        }
    }

    override fun onBackPressed() {
        val viewModel: MainViewModel by viewModels()
        if (viewModel.currentDog != null) {
            viewModel.closeDogDetail()
        } else {
            super.onBackPressed()
        }
    }
}

@Composable
fun MainScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            val pagerState: PagerState = run {
                remember { PagerState(maxPage = 1) }
            }
            Pager(pagerState, Modifier.weight(1f)) {
                when (page) {
                    0 -> DogList()
                    1 -> MyDogList()
                }
            }
            MyBottomNavigation(pagerState = pagerState)
        }
    }
}

@Composable
fun MyBottomNavigation(pagerState: PagerState) {
    BottomNavigation {
        BottomNavigationItem(
            selected = pagerState.currentPage == 0,
            onClick = { pagerState.currentPage = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "小狗列表",
                    tint = if (pagerState.currentPage == 0) Color.White else Color.LightGray,
                    modifier = Modifier.scale(if (pagerState.currentPage == 0) 1.1f else 1.0f),
                )
            },
            label = {
                Text(
                    text = "小狗列表",
                    style = TextStyle(color = if (pagerState.currentPage == 0) Color.White else Color.LightGray)
                )
            },
        )
        BottomNavigationItem(
            selected = pagerState.currentPage == 1,
            onClick = { pagerState.currentPage = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.VerifiedUser,
                    contentDescription = "我的小狗",
                    tint = if (pagerState.currentPage == 1) Color.White else Color.LightGray,
                    modifier = Modifier.scale(if (pagerState.currentPage == 1) 1.1f else 1.0f),
                )
            },
            label = {
                Text(
                    text = "我的小狗",
                    style = TextStyle(color = if (pagerState.currentPage == 1) Color.White else Color.LightGray)
                )
            },
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MainScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MainScreen()
    }
}
