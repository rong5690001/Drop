package com.rong.drop.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.FloatRange
import android.support.v4.view.ViewCompat
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout

import com.rong.drop.R

/**
 * Created by chen.huarong on 2017/11/20.
 */

object SystemBarUtil {

    private val DEFAULT_ALPHA = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) 0.2f else 0.3f

    /**
     * Android4.4以上的沉浸式全屏模式
     * 注:
     * 1.删除fitsSystemWindows属性:Android5.0以上使用该方法如果出现界面展示不正确,删除布局中所有fitsSystemWindows属性
     * 或者调用forceFitsSystemWindows方法
     * 2.不删除fitsSystemWindows属性:也可以区别处理,Android5.0以上使用自己的方式实现,不调用该方法
     *
     * @param activity Activity对象
     * @param alpha    透明栏透明度[0.0-1.0]
     */
    fun immersiveStatusBar(activity: Activity, @FloatRange(from = 0.0, to = 1.0) alpha: Float) {
        immersiveStatusBar(activity.window, alpha)
    }

    /**
     * Android4.4以上的沉浸式全屏模式
     * 注:
     * 1.删除fitsSystemWindows属性:Android5.0以上使用该方法如果出现界面展示不正确,删除布局中所有fitsSystemWindows属性
     * 或者调用forceFitsSystemWindows方法
     * 2.不删除fitsSystemWindows属性:也可以区别处理,Android5.0以上使用自己的方式实现,不调用该方法
     *
     * @param window 一般都是用于Activity的window,也可以是其他的例如Dialog,DialogFragment
     * @param alpha  透明栏透明度[0.0-1.0]
     */
    @JvmOverloads
    fun immersiveStatusBar(window: Window, @FloatRange(from = 0.0, to = 1.0) alpha: Float = DEFAULT_ALPHA) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT

            var systemUiVisibility = window.decorView.systemUiVisibility
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = systemUiVisibility
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        val decorView = window.decorView as ViewGroup
        val contentView = window.decorView.findViewById<View>(Window.ID_ANDROID_CONTENT) as ViewGroup
        val rootView = contentView.getChildAt(0)
        val statusBarHeight = getStatusBarHeight(window.context)
        if (rootView != null) {
            val lp = rootView.layoutParams as FrameLayout.LayoutParams
            ViewCompat.setFitsSystemWindows(rootView, true)
            lp.topMargin = -statusBarHeight
            rootView.layoutParams = lp
        }

        setTranslucentView(decorView, alpha)
    }

    /**
     * 获取状态栏高度
     */
    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resId > 0) {
            result = context.resources.getDimensionPixelSize(resId)
        }
        return result
    }

    /**
     * 创建假的透明栏
     */
    private fun setTranslucentView(container: ViewGroup,
                                   @FloatRange(from = 0.0, to = 1.0) alpha: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            var translucentView: View? = container.findViewById(R.id.translucent_view)
            if (translucentView == null) {
                translucentView = View(container.context)
                translucentView.id = R.id.translucent_view
                val lp = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(container.context))
                container.addView(translucentView, lp)
            }

            translucentView.setBackgroundColor(Color.argb((alpha * 255).toInt(), 0, 0, 0))
        }
    }
}
/**
 * Android4.4以上的沉浸式全屏模式
 * 注:
 * 1.删除fitsSystemWindows属性:Android5.0以上使用该方法如果出现界面展示不正确,删除布局中所有fitsSystemWindows属性
 * 或者调用forceFitsSystemWindows方法
 * 2.不删除fitsSystemWindows属性:也可以区别处理,Android5.0以上使用自己的方式实现,不调用该方法
 *
 * @param window 一般都是用于Activity的window,也可以是其他的例如Dialog,DialogFragment
 */
