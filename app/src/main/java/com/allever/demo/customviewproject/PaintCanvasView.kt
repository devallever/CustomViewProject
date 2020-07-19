package com.allever.demo.customviewproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.allever.demo.customviewproject.util.DisplayUtils

class PaintCanvasView : View {

    private lateinit var mPaint: Paint

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
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawPoint(canvas)

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

}