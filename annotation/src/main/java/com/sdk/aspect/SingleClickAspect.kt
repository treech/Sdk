package com.sdk.aspect

import android.util.Log
import android.view.View
import com.sdk.annotation.R
import com.sdk.annotation.SingleClick
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

/** Author：yeguoqiang Created time：2020/5/8 17:18  */
@Aspect
class SingleClickAspect {
    @Pointcut("execution(@com.sdk.annotation.SingleClick * *(..))") // 方法切入点
    fun onSingleClickMethod() {
    }

    @Around("onSingleClickMethod() && @annotation(singleClick)") // 在连接点进行方法替换
    @Throws(Throwable::class)
    fun doSingleClickMethod(joinPoint: ProceedingJoinPoint, singleClick: SingleClick) {
        var view: View? = null
        for (arg in joinPoint.args) {
            if (arg is View) {
                view = arg
                break
            }
        }
        if (view != null) {
            val tag = view.getTag(TIME_TAG)
            val lastClickTime = if (tag == null) 0 else tag as Long
            val currentTime = System.currentTimeMillis()
            val value: Long = singleClick.value
            val ids: IntArray = singleClick.ids
            if (currentTime - lastClickTime > value
                || !hasId(ids, view.id)
            ) { // 过滤掉500毫秒内的连续点击
                view.setTag(TIME_TAG, currentTime)
                Log.w(TAG, "currentTime:$currentTime,lastClickTime:$lastClickTime")
                joinPoint.proceed() // 执行原方法
            }
        }
    }

    companion object {
        private const val TAG = "SingleClickAspect"
        private val TIME_TAG = R.id.click_time
        private fun hasId(ids: IntArray, value: Int): Boolean {
            for (id in ids) {
                if (id == value) {
                    return true
                }
            }
            return false
        }
    }
}