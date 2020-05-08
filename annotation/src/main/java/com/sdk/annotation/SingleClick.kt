package com.sdk.annotation

import android.view.View

/** Author：yeguoqiang Created time：2020/5/8 17:15  */
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class SingleClick(
    val value: Long = 500L,
    val ids: IntArray = [View.NO_ID]
)