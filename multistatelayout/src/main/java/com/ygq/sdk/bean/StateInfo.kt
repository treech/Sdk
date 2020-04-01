package com.ygq.sdk.bean

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.ygq.sdk.constants.NULL_RESOURCE_ID

data class StateInfo(
    val state: Int = -1,   //视图状态
    @LayoutRes var layoutId: Int = NULL_RESOURCE_ID,   //视图布局Id
    @IdRes var hintId: Int = NULL_RESOURCE_ID,
    var hintText: String? = null,
    val clickViewIds: List<Int> = listOf()  //设置点击事件的控件Id
)