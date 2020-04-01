package com.ygq.sample

import android.os.Bundle
import com.ygq.sample.base.BaseMenuActivity
import com.ygq.sample.constants.*
import kotlinx.android.synthetic.main.activity_constraint_status.*

class ConstraintStateActivity : BaseMenuActivity() {


    override fun showLoading() {
        stateLayout.showLoading()
    }

    override fun showContent() {
        stateLayout.showContent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_status)
        stateLayout.setOnViewsClickListener(stateViewClickListener)
        stateLayout.setOnViewStateChangeListener(statusChangeListener)
    }

    override fun onMenuItemClickListener(id: Int) {
        when (id) {
            MENU_CONTENT -> stateLayout.showContent()
            MENU_EMPTY -> stateLayout.showEmpty()
            MENU_LOADING -> stateLayout.showLoading()
            MENU_ERROR -> stateLayout.showError()
            MENU_NO_NETWORK -> stateLayout.showNoNetwork()
            MENU_NEED_LOGIN -> stateLayout.showStateView(STATE_NEED_LOGIN)
            MENU_NO_COUPON -> stateLayout.showStateView(STATE_NO_COUPON)
        }
    }
}
