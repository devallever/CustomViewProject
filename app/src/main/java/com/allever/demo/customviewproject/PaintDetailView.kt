package com.allever.demo.customviewproject

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PaintDetailView: View {

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

        setColorBase(canvas)

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

}