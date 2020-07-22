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
//
//        setColorWithLightColorFilter(canvas)
//
//        setColorWithPorterDuffColorFilter(canvas)
//
//
//        lineShape(canvas)
//
//        pathEffect(canvas)
//
        shadowLayer(canvas)


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

    private fun setColorWithLightColorFilter(canvas: Canvas?) {
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

    private fun setColorWithPorterDuffColorFilter(canvas: Canvas?) {
        mPaint.reset()
        val colorFilter = PorterDuffColorFilter(0xff00ff, PorterDuff.Mode.SRC)
        mPaint.colorFilter = colorFilter
        canvas?.drawBitmap(mBitmap, 50f, 50f, mPaint)
    }

    private fun lineShape(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 30f
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.style = Paint.Style.STROKE

        var path = Path()
        path.moveTo(50f, 150f)
        path.lineTo(150f, 50f)
        path.lineTo(250f, 150f)
        path.lineTo(350f, 50f)
        path.lineTo(450f, 150f)
        path.lineTo(550f, 50f)
        path.lineTo(650f, 150f)
        mPaint.strokeJoin = Paint.Join.MITER //默认
        canvas?.drawPath(path, mPaint)

        path = Path()
        path.moveTo(50f, 350f)
        path.lineTo(150f, 250f)
        path.lineTo(250f, 350f)
        path.lineTo(350f, 250f)
        path.lineTo(450f, 350f)
        path.lineTo(550f, 250f)
        path.lineTo(650f, 350f)
        mPaint.strokeJoin = Paint.Join.BEVEL
        canvas?.drawPath(path, mPaint)

        path = Path()
        path.moveTo(50f, 550f)
        path.lineTo(150f, 450f)
        path.lineTo(250f, 550f)
        path.lineTo(350f, 450f)
        path.lineTo(450f, 550f)
        path.lineTo(550f, 450f)
        path.lineTo(650f, 550f)
        mPaint.strokeJoin = Paint.Join.ROUND
        canvas?.drawPath(path, mPaint)
    }

    private fun pathEffect(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 10f
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeCap = Paint.Cap.ROUND

        var path = Path()
        path.moveTo(50f, 150f)
        path.lineTo(150f, 50f)
        path.lineTo(250f, 150f)
        path.lineTo(350f, 50f)
        path.lineTo(450f, 150f)
        path.lineTo(550f, 50f)
        path.lineTo(650f, 150f)
        //把拐角变成圆角
        val cornerPathEffect = CornerPathEffect(20f)
        mPaint.pathEffect = cornerPathEffect
        canvas?.drawPath(path, mPaint)

        path = Path()
        path.moveTo(50f, 250f)
        path.lineTo(150f, 150f)
        path.lineTo(250f, 250f)
        path.lineTo(350f, 150f)
        path.lineTo(450f, 250f)
        path.lineTo(550f, 150f)
        path.lineTo(650f, 250f)
        //把线条进行随机的偏离，让轮廓变得乱七八糟。
        val discretePathEffect = DiscretePathEffect(20f, 10f)
        mPaint.pathEffect = discretePathEffect
        canvas?.drawPath(path, mPaint)

        path = Path()
        path.moveTo(50f, 350f)
        path.lineTo(150f, 250f)
        path.lineTo(250f, 350f)
        path.lineTo(350f, 250f)
        path.lineTo(450f, 350f)
        path.lineTo(550f, 250f)
        path.lineTo(650f, 350f)
        //虚线效果
        val params = listOf(30f, 20f).toFloatArray()
        val dashPathEffect = DashPathEffect(params, 0f)
        mPaint.pathEffect = dashPathEffect
        canvas?.drawPath(path, mPaint)

        path = Path()
        path.moveTo(50f, 450f)
        path.lineTo(150f, 350f)
        path.lineTo(250f, 450f)
        path.lineTo(350f, 350f)
        path.lineTo(450f, 450f)
        path.lineTo(550f, 350f)
        path.lineTo(650f, 450f)
        //使用路径作为虚线分割
        val circlePath = Path()
        circlePath.addCircle(0f, 0f, 10f, Path.Direction.CW)
        val pathDashPathEffect = PathDashPathEffect(circlePath, 30f, 0f, PathDashPathEffect.Style.TRANSLATE)
        mPaint.pathEffect = pathDashPathEffect
        canvas?.drawPath(path, mPaint)

        path = Path()
        path.moveTo(50f, 550f)
        path.lineTo(150f, 450f)
        path.lineTo(250f, 550f)
        path.lineTo(350f, 450f)
        path.lineTo(450f, 550f)
        path.lineTo(550f, 450f)
        path.lineTo(650f, 550f)
        val sumPathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
        mPaint.pathEffect = sumPathEffect
        canvas?.drawPath(path, mPaint)


        path = Path()
        path.moveTo(50f, 650f)
        path.lineTo(150f, 550f)
        path.lineTo(250f, 650f)
        path.lineTo(350f, 550f)
        path.lineTo(450f, 650f)
        path.lineTo(550f, 550f)
        path.lineTo(650f, 650f)
        val composePathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)
        mPaint.pathEffect = composePathEffect
        canvas?.drawPath(path, mPaint)
    }

    private fun shadowLayer(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.style = Paint.Style.STROKE
        mPaint.textSize = 80f

        val text = "Hello Android"
        mPaint.setShadowLayer(10f, 0f, 0f, Color.RED)
        canvas?.drawText(text, 100f, 100f, mPaint)
    }
}