package com.ygq.sample.base

import android.os.Bundle
import com.ygq.sample.R
import kotlinx.android.synthetic.main.activity_sample.*

abstract class BaseFrameStatusActivity: BaseMenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        stateLayout.setOnViewsClickListener(stateViewClickListener)
        stateLayout.setOnViewStateChangeListener(statusChangeListener)
    }

}