package com.ygq.sample

import com.ygq.sample.base.BaseFrameStatusActivity
import com.ygq.sample.constants.*
import kotlinx.android.synthetic.main.activity_sample.*

class FrameStateActivity : BaseFrameStatusActivity() {
    override fun showLoading() {
        stateLayout.showLoading()
    }

    override fun showContent() {
        //显示内容视图
        stateLayout.showContent()
        /*  //显示加载中视图
          stateLayout.showLoading()
          //显示空数据视图
          stateLayout.showEmpty()
          //显示断网视图
          stateLayout.showNoNetwork()
          //显示错误视图
          stateLayout.showError()
          //获取当前的视图状态
          stateLayout.currentState*/
    }

    override fun onMenuItemClickListener(id: Int) {
        when (id) {
            MENU_CONTENT -> stateLayout.showContent()
            MENU_LOADING -> stateLayout.showLoading()
            MENU_EMPTY -> stateLayout.showEmpty()
            MENU_ERROR -> stateLayout.showError()
            MENU_NO_NETWORK -> stateLayout.showNoNetwork()
            MENU_NEED_LOGIN -> stateLayout.showStateView(STATE_NEED_LOGIN)
            MENU_NO_COUPON -> stateLayout.showStateView(STATE_NO_COUPON)
        }
    }

}
