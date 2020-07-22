package com.allever.demo.customviewproject

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PaintDetailView : View {

    private lateinit var mPaint: Paint

    private lateinit var mBitmap: Bitmap

    constructor(context: Context) : this(context, null) {}
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, themeRes: Int) : super(
        context,
        attributeSet,
        themeRes
    ) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint.isAntiAlias = true
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.test_img)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        setColorBase(canvas)
//
//        setColorWithLinearGradient(canvas)
//
//        setColorWithRadialGradient(canvas)
//
//        setColorWithSweepGradient(canvas)
//
//        setColorWithBitmapShader(canvas)

        setColorWithColorFilter(canvas)

    }

    private fun setColorBase(canvas: Canvas?) {
        //使用Canvas填充画布颜色
        canvas?.drawColor(resources.getColor(R.color.colorAccent))
        //使用Bitmap复制颜色像素到画布
        canvas?.drawBitmap(mBitmap, 50f, 250f, mPaint)

        //setColor()
        mPaint.color = resources.getColor(R.color.colorPrimary)
        val text = "Hello Android"
        mPaint.textSize = 45f
        canvas?.drawText(text, 100f, 100f, mPaint)

        //setARGB()
        mPaint.setARGB(255, 255, 0, 0)
        mPaint.textSize = 75f
        canvas?.drawText(text, 100f, 200f, mPaint)
    }

    private fun setColorWithLinearGradient(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)

        val startColor = resources.getColor(R.color.colorPrimary)
        val endColor = resources.getColor(R.color.colorAccent)

        //线性渐变的三种模式
        var linearGradientShader =
            LinearGradient(50f, 100f, 200f, 100f, startColor, endColor, Shader.TileMode.CLAMP)
        mPaint.shader = linearGradientShader
        canvas?.drawRect(RectF(50f, 50f, 200f, 150f), mPaint)

        linearGradientShader =
            LinearGradient(250f, 100f, 325f, 100f, startColor, endColor, Shader.TileMode.MIRROR)
        mPaint.shader = linearGradientShader
        canvas?.drawRect(RectF(250f, 50f, 400f, 150f), mPaint)

        linearGradientShader =
            LinearGradient(450f, 100f, 400f, 100f, startColor, endColor, Shader.TileMode.REPEAT)
        mPaint.shader = linearGradientShader
        canvas?.drawRect(RectF(450f, 50f, 600f, 150f), mPaint)

    }

    private fun setColorWithRadialGradient(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)

        val startColor = resources.getColor(R.color.colorPrimary)
        val endColor = resources.getColor(R.color.colorAccent)

        //辐射渐变渐变的三种模式
        var radialGradientShader =
            RadialGradient(50f, 250f, 50f, startColor, endColor, Shader.TileMode.CLAMP)
        mPaint.shader = radialGradientShader
        canvas?.drawRect(RectF(50f, 200f, 200f, 300f), mPaint)

        radialGradientShader =
            RadialGradient(250f, 250f, 50f, startColor, endColor, Shader.TileMode.MIRROR)
        mPaint.shader = radialGradientShader
        canvas?.drawRect(RectF(250f, 200f, 400f, 300f), mPaint)

        radialGradientShader =
            RadialGradient(450f, 250f, 50f, startColor, endColor, Shader.TileMode.REPEAT)
        mPaint.shader = radialGradientShader
        canvas?.drawRect(RectF(450f, 200f, 600f, 300f), mPaint)

    }

    private fun setColorWithSweepGradient(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        val startColor = resources.getColor(R.color.colorPrimary)
        val endColor = resources.getColor(R.color.colorAccent)

        val centerX = measuredWidth/4f
        val centerY = 450f
        val sweepGradientShader = SweepGradient(centerX, centerY, startColor, endColor)
        mPaint.shader = sweepGradientShader
        canvas?.drawCircle(centerX, centerY, 100f, mPaint)
    }

    private fun setColorWithBitmapShader(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)

        val centerX = measuredWidth/4f * 3
        val centerY = 450f
        val bitmapShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mPaint.shader = bitmapShader
        canvas?.drawCircle(centerX+50, centerY+50, 100f, mPaint)
    }

    private fun setColorWithColorFilter(canvas: Canvas?) {
        mPaint.reset()

//        //原始
//        val colorFilter = LightingColorFilter(0xffffff, 0x000000)
//        mPaint.colorFilter = colorFilter
//        canvas?.drawBitmap(mBitmap, 50f, 50f, mPaint)

//        //去掉红色
//        val colorFilter = LightingColorFilter(0x00ffff, 0x000000)
//        mPaint.colorFilter = colorFilter
//        canvas?.drawBitmap(mBitmap, 50f, 50f, mPaint)

//        //增强红色
//        val colorFilter = LightingColorFilter(0xffffff, 0x500000)
//        mPaint.colorFilter = colorFilter
//        canvas?.drawBitmap(mBitmap, 50f, 50f, mPaint)

//        //增强红色和蓝色
//        val colorFilter = LightingColorFilter(0xffffff, 0x500030)
//        mPaint.colorFilter = colorFilter
//        canvas?.drawBitmap(mBitmap, 50f, 50f, mPaint)

        //增强红色和蓝色， 去掉绿色
        val colorFilter = LightingColorFilter(0xff00ff, 0x500030)
        mPaint.colorFilter = colorFilter
        canvas?.drawBitmap(mBitmap, 50f, 50f, mPaint)
    }
}