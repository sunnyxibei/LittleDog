package com.sunnyxibei.littledog.ui.fragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sunnyxibei.littledog.ui.activity.MainViewModel
import com.sunnyxibei.littledog.ui.theme.typography

/**
 * 小狗详情页面
 */
@Composable
fun DogDetail() {
    val viewModel: MainViewModel = viewModel()
    val dog = viewModel.currentDog!!
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(48.dp),
    ) {
        val adopted = remember { mutableStateOf(dog.adopted) }
        Column {
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = dog.banner),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(12.dp))
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = dog.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .padding(12.dp),
                )
                Text(
                    text = dog.name,
                    style = typography.h5,
                    modifier = Modifier.padding(12.dp),
                )

            }
            Text(
                text = "年龄：${dog.age}",
                style = typography.caption,
                modifier = Modifier.padding(12.dp),
            )
            Text(
                text = "出生日期：${dog.birthday}",
                style = typography.caption,
                modifier = Modifier.padding(12.dp),
            )
            Text(
                text = dog.desc,
                style = typography.body1,
                modifier = Modifier.padding(12.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Rounded.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.padding(12.dp),
                )
                Text(
                    text = dog.city,
                    style = typography.body2,
                    modifier = Modifier.padding(vertical = 12.dp),
                )
            }
            Button(onClick = {
                dog.adopted = !dog.adopted
                if (dog.adopted) {
                    viewModel.dogList.remove(dog)
                    viewModel.myDogList.add(dog)
                }else{
                    viewModel.myDogList.remove(dog)
                    viewModel.dogList.add(dog)
                }
                adopted.value = dog.adopted
            }) {
                Text(text = if (adopted.value) "取消领养" else "确定领养")
            }
        }
    }

}