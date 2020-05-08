package com.ygq.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sdk.annotation.SingleClick
import kotlinx.android.synthetic.main.activity_main.*


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGlobalSetting.setOnClickListener {
            startActivity(FrameStateActivity::class.java)
        }
        btnCustomSetting.setOnClickListener {
            startActivity(FrameStateActivity2::class.java)
        }
        btnLinear.setOnClickListener {
            startActivity(LinearStateActivity::class.java)
        }
        btnConstrain.setOnClickListener {
            startActivity(ConstraintStateActivity::class.java)
        }
        findViewById<Button>(R.id.singleClick).setOnClickListener(this)
        findViewById<Button>(R.id.singleClick2).setOnClickListener(this)
        findViewById<Button>(R.id.singleClick3).setOnClickListener(this)
    }

    private fun startActivity(cls: Class<*>?) {
        startActivity(Intent(this, cls))
    }

    @SingleClick(ids = [R.id.singleClick, R.id.singleClick2])
    override fun onClick(v: View) {
        when (v.id) {
            R.id.singleClick -> {
                Log.e(TAG, "防抖")
            }
            R.id.singleClick2 -> {
                Log.e(TAG, "防抖2")
            }
            R.id.singleClick3 -> {
                Log.e(TAG, "不防抖")
            }
        }
    }

}
