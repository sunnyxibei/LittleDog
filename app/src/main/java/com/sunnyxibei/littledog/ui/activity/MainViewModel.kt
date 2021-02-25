package com.sunnyxibei.littledog.ui.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sunnyxibei.littledog.R
import com.sunnyxibei.littledog.data.Dog

class MainViewModel : ViewModel() {

    /**
     * 所有待收养的小狗列表
     */
    var dogList: MutableList<Dog> by mutableStateOf(
        mutableListOf(
            Dog(
                name = "雪纳瑞",
                age = 2,
                birthday = "2019-2-2",
                city = "杭州",
                desc = "雪纳瑞，其名字源自德语“Schnauze”，就是“大胡子”的意思。而该犬的确有着一团像草堆般的大胡子，再加之憨厚的长脸孔和一双满溢热情及盼望的大眼睛，深受各国犬迷的喜爱。雪纳瑞犬有三个品种，分别为巨型、标准型和迷你型雪纳瑞犬；三个品种中．标准雪纳瑞犬的历史最为悠久，巨型雪纳瑞犬的年代最近，迷你雪纳瑞犬最受人欢迎",
                avatar = R.drawable.ic_dog_1,
                banner = R.drawable.img_dog_3,
            ),
            Dog(
                name = "金毛",
                age = 3,
                birthday = "2018-7-12",
                city = "上海",
                desc = "金毛寻回犬是最常见的家犬之一，它很容易养，有耐心并且对主人要求不多，只要定期运动，饲喂食物和兽医体检就可以了。它属于匀称、有力、活泼的一个犬种，特征是稳固、身体各部位配合合理，腿既不太长也不笨拙，表情友善，个性热情、机警、自信而且不怕生，性格讨人喜欢。金毛犬最早是一种寻回猎犬，大多作为导盲犬与宠物狗。对小孩子或者婴儿十分友善。金毛犬是位列世界犬种智商排行的第四名。",
                avatar = R.drawable.ic_dog_2,
                banner = R.drawable.img_dog_2,
            ),
            Dog(
                name = "拉布拉多",
                age = 2,
                birthday = "2019-3-22",
                city = "光明顶",
                desc = "拉布拉多又称寻回犬，是一种中大型犬类，是非常适合被选作经常出入公共场合的导盲犬或地铁警犬及搜救犬和其他工作犬的狗品种，因原产地在加拿大的纽芬兰与拉布拉多省而得名。",
                avatar = R.drawable.ic_dog_3,
                banner = R.drawable.img_dog_1,
            ),
            Dog(
                name = "哈士奇",
                age = 2,
                birthday = "2019-4-1",
                city = "嘉兴",
                desc = "西伯利亚雪橇犬是原始的古老犬种，主要生活在在西伯利亚东北部、格陵兰南部。哈士奇名字是源自其独特的嘶哑叫声 [1]  。哈士奇性格多变，有的极端胆小，也有的极端暴力，进入人类社会和家庭的哈士奇，都已经没有了这种极端的性格，比较温顺，是一种流行于全球的宠物犬。哈士奇、金毛犬与拉布拉多并列为三大无攻击性犬类 [2]  ，被世界各地人们广泛饲养，并在全球范围内有大量该犬种的赛事。",
                avatar = R.drawable.ic_dog_4,
                banner = R.drawable.img_dog_4,
            ),
            Dog(
                name = "松狮",
                age = 3,
                birthday = "2018-2-14",
                city = "深圳",
                desc = "松狮犬集美丽、高贵和自然于一身，拥有独特的蓝舌头、愁苦的表情和夸张的步法，但不是很听话，有时会非常独立，而且眼睛深陷，视力范围有限 [1]  。在古代曾名为獢獢。",
                avatar = R.drawable.ic_dog_5,
                banner = R.drawable.img_dog_3,
            ),
            Dog(
                name = "博美",
                age = 3,
                birthday = "2018-12-12",
                city = "广州",
                desc = "博美是一种紧凑、短背、活跃的玩赏犬，学名哈多利系博美犬（俗称英系博美犬），是德国狐狸犬的一种，原产德国。它拥有柔软、浓密的底毛和粗硬的皮毛。",
                avatar = R.drawable.ic_dog_6,
                banner = R.drawable.img_dog_2,
            ),
        )
    )

    /**
     * 我已经收养的小狗列表
     */
    var myDogList: MutableList<Dog> by mutableStateOf(mutableListOf())

    var currentDog: Dog? by mutableStateOf(null)
        private set

    fun openDogDetail(value: Dog) {
        currentDog = value
    }

    fun closeDogDetail() {
        currentDog = null
    }
}