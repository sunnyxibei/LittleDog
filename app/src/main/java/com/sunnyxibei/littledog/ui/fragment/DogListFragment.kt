package com.sunnyxibei.littledog.ui.fragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.NoAccounts
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sunnyxibei.littledog.data.Dog
import com.sunnyxibei.littledog.ui.activity.MainViewModel
import com.sunnyxibei.littledog.ui.theme.purple200
import com.sunnyxibei.littledog.ui.theme.typography

/**
 * 小狗列表页面
 */
@Composable
@Preview
fun DogList() {
    Column(modifier = Modifier.fillMaxSize()) {
        val viewModel: MainViewModel = viewModel()
        IntervalDogList(viewModel.dogList) {
            viewModel.openDogDetail(it)
        }
    }
}

@Composable
fun MyDogList() {
    val viewModel: MainViewModel = viewModel()
    Box(modifier = Modifier.fillMaxSize()) {
        if (viewModel.myDogList.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Rounded.NoAccounts,
                        tint = purple200,
                        contentDescription = null
                    )
                    Text(
                        text = "你还未收养小狗，快去挑选你心爱的狗狗吧",
                        style = typography.overline,
                        modifier = Modifier.padding(12.dp),
                    )
                }
            }
        } else {
            IntervalDogList(viewModel.myDogList) {
                viewModel.openDogDetail(it)
            }
        }
    }
}

@Composable
fun IntervalDogList(dogList: List<Dog>, onClick: (Dog) -> Unit) {
    LazyColumn(Modifier.fillMaxWidth()) {
        itemsIndexed(dogList) { index, dog ->
            Card(modifier = Modifier
                .padding(12.dp)
                .clickable { onClick.invoke(dog) }) {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(12.dp)
                ) {
                    Column {
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
                    }
                }
            }
        }
    }
}
