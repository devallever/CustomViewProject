package com.allever.demo.customviewproject.util

import android.app.Service
import android.util.DisplayMetrics
import android.view.WindowManager
import com.allever.demo.customviewproject.App

/**
 * Created by allever on 17-8-5.
 * 单位转换工具类
 */

object DisplayUtils {

    private val TAG = DisplayUtils::class.java.simpleName

    /**
     * 将px转换成dip或dp
     * @param context
     * @param px 像素值
     * @density 转换比例 例如1dp = 3px, density值就是3
     *
     * 320x480      mdpi    1dp = 1px   density = 1
     * 480x800      hdpi    1dp = 1.5px density = 1.5
     * 720x1280     xhdpi   1dp = 2px   density = 2
     * 1080x1920    xxhdpi  1dp = 3px   density = 3
     * 1440x2560    xxxhdpi 1dp = 4px   density = 4
     *
     * @result 返回dip或dp值
     */
    fun px2dp(px: Int): Int {
        val density = App.context.resources.displayMetrics.density
        return (px / density + 0.5f).toInt()
    }

    fun dp2px(dip: Int): Int {
        val density = App.context.resources.displayMetrics.density
        return (dip * density + 0.5f).toInt()
    }

    fun dp2px(dip: Float): Int {
        val density = App.context.resources.displayMetrics.density
        return (dip * density + 0.5f).toInt()
    }

    fun px2sp(px: Int): Int {
        val scaledDensity = App.context.resources.displayMetrics.scaledDensity
        return (px / scaledDensity + 0.5f).toInt()
    }

    fun sp2px(sp: Int): Int {
        val scaledDensity = App.context.resources.displayMetrics.scaledDensity
        return (sp * scaledDensity + 0.5f).toInt()
    }

    fun getDeviceDensity(): Float {
        return App.context.resources.displayMetrics.density
    }

    fun getDisplayMetrics(): DisplayMetrics {
        return App.context.resources.displayMetrics
    }

    fun getScreenWidth(): Int {
        return getScreenRealMetrics().widthPixels
    }

    fun getScreenHeight(): Int {
        return getScreenRealMetrics().heightPixels
    }

    private fun getScreenRealMetrics(): DisplayMetrics {
        val displayMetrics = DisplayMetrics()
        val wm = App.context.getSystemService(Service.WINDOW_SERVICE) as? WindowManager
        wm?.defaultDisplay?.getRealMetrics(displayMetrics)
        return displayMetrics
    }
}
