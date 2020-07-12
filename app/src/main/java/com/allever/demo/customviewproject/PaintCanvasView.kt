package com.allever.demo.customviewproject

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.allever.demo.customviewproject.util.DisplayUtils

class PaintCanvasView : View {

    private lateinit var mPaint: Paint
    private var mMeasureWidth: Int = 0

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
        mPaint.color = resources.getColor(R.color.colorPrimary)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        drawRGB(canvas)
//
//        drawColor(canvas)
//
//        drawPoint(canvas)
//
//        drawLine(canvas)

        drawCircle(canvas)

        drawRect(canvas)

        drawRoundRect(canvas)


    }

    private fun drawPoint(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 30f

        //设置点形状, 圆头、平头、方头
        mPaint.strokeCap = Paint.Cap.ROUND
        canvas?.drawPoint(100f, 100f, mPaint)

        mPaint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawPoint(200f, 100f, mPaint)

        mPaint.strokeCap = Paint.Cap.BUTT
        canvas?.drawPoint(300f, 100f, mPaint)

        mPaint.strokeCap = Paint.Cap.ROUND
        val pointsY = 200f
        val points = listOf(
            100f, pointsY,
            200f, pointsY,
            300f, pointsY,
            400f, pointsY,
            500f, pointsY
        ).toFloatArray()
        canvas?.drawPoints(points, mPaint)
    }

    private fun drawLine(canvas: Canvas?) {
        mPaint.reset()
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.isAntiAlias = true

        mPaint.strokeWidth = 10f
        mPaint.strokeCap = Paint.Cap.ROUND
        canvas?.drawLine(100f, 300f, mMeasureWidth - 100f, 300f, mPaint)

        mPaint.strokeWidth = 10f
        mPaint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawLine(100f, 400f, mMeasureWidth - 100f, 400f, mPaint)

        mPaint.strokeWidth = 10f
        mPaint.strokeCap = Paint.Cap.BUTT
        canvas?.drawLine(100f, 500f, mMeasureWidth - 100f, 500f, mPaint)

        mPaint.strokeWidth = 20f
        mPaint.strokeCap = Paint.Cap.ROUND
        val lines = listOf(
            100f, 600f, mMeasureWidth - 100f, 600f,
            100f, 700f, mMeasureWidth - 100f, 700f
        ).toFloatArray()
        canvas?.drawLines(lines, mPaint)

    }

    private fun drawColor(canvas: Canvas?) {
        canvas?.drawColor(resources.getColor(R.color.colorAccent))
        //canvas?.drawColor(Color.parseColor("#03DAC5"))
    }

    private fun drawRGB(canvas: Canvas?) {
        canvas?.drawRGB(255, 0, 0)
//        canvas?.drawARGB(128, 255, 0, 0)
    }

    private fun drawCircle(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 10f

        mPaint.style = Paint.Style.FILL
        canvas?.drawCircle(100f, 100f, 50f, mPaint)

        mPaint.style = Paint.Style.STROKE
        canvas?.drawCircle(300f, 100f, 50f, mPaint)

        mPaint.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawCircle(500f, 100f, 50f, mPaint)

    }

    private fun drawRect(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 10f

        mPaint.style = Paint.Style.FILL
        canvas?.drawRect(50f, 200f, 200f, 300f, mPaint)

        mPaint.style = Paint.Style.STROKE
        val rect = Rect(250, 200, 400, 300)
        canvas?.drawRect(rect, mPaint)

        mPaint.style = Paint.Style.FILL_AND_STROKE
        val rectF = RectF(450f, 200f, 600f, 300f)
        canvas?.drawRect(rectF, mPaint)
    }

    private fun drawRoundRect(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 10f

        mPaint.style = Paint.Style.FILL
        canvas?.drawRoundRect(50f, 350f, 200f, 450f, 10f, 10f,  mPaint)

        mPaint.style = Paint.Style.STROKE
        val rectF1 = RectF(250f, 350f, 400f, 450f)
        canvas?.drawRoundRect(rectF1, 20f, 20f,  mPaint)

        mPaint.style = Paint.Style.FILL_AND_STROKE
        val rectF2 = RectF(450f, 350f, 600f, 450f)
        canvas?.drawRoundRect(rectF2, 30f, 30f,  mPaint)
    }
}