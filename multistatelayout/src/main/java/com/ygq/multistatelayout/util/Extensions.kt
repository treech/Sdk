package com.ygq.multistatelayout.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View

internal fun Context.inflateView(layoutId: Int): View =
    LayoutInflater.from(this).inflate(layoutId, null)




