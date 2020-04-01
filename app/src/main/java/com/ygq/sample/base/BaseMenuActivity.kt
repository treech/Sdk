package com.ygq.sample.base

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ygq.sample.R
import com.ygq.sample.constants.*

abstract class BaseMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    protected val stateViewClickListener: (state: Int, view: View) -> Unit = { state, view ->
        when (view.id) {
            R.id.btnError, R.id.btnNoNetwork -> {
                showLoading()
                Handler().postDelayed({
                    showContent()
                }, 2000)
            }
            R.id.btnLogin -> Toast.makeText(this, "点击登录", Toast.LENGTH_LONG).show()
            R.id.ivEmpty -> Toast.makeText(this, "没有数据啦", Toast.LENGTH_LONG).show()
        }
    }

    protected val statusChangeListener: (oldStatus: Int, curStatus: Int) -> Unit =
        { oldStatus, curStatus ->
            Log.d(com.ygq.sample.TAG, "oldStatus=$oldStatus,newStatus=$curStatus")
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, MENU_CONTENT, 1, "内容视图")
        menu.add(0, MENU_LOADING, 1, "加载中视图")
        menu.add(0, MENU_EMPTY, 1, "空数据视图")
        menu.add(0, MENU_ERROR, 1, "错误视图")
        menu.add(0, MENU_NO_NETWORK, 1, "网络断开视图")
        menu.add(0, MENU_NEED_LOGIN, 1, "需要登录视图")
        menu.add(0, MENU_NO_COUPON, 1, "没有优惠券视图")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        onMenuItemClickListener(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    abstract fun onMenuItemClickListener(id: Int)
    abstract fun showLoading()
    abstract fun showContent()
}