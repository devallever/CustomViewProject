package com.allever.demo.customviewproject

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class XfermodeView : View {

    private lateinit var mPaint: Paint

    private val mWidth = 200
    private val mHeight = 200
    private lateinit var mDstBitmap: Bitmap
    private lateinit var mSrcBitmap: Bitmap

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
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        mPaint = Paint()
        mPaint.isAntiAlias = true

        mDstBitmap = makeDstBitmap(mWidth, mHeight)
        mSrcBitmap = makeSrcBitmap(mWidth, mHeight)


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        originWithoutXfermode(canvas)
    }

    private fun originWithoutXfermode(canvas: Canvas?) {
        canvas?.drawBitmap(mDstBitmap, 0f, 0f, mPaint)
        canvas?.drawBitmap(mSrcBitmap, mWidth/2f, mHeight/2f, mPaint)
    }

    private fun makeDstBitmap(width: Int, height: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.parseColor("#ffffcc44")
        canvas.drawOval(RectF(0f, 0f, width.toFloat(), height.toFloat()), paint)
        return bitmap
    }

    private fun makeSrcBitmap(width: Int, height: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.parseColor("#ff66aaff")
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        return bitmap
    }

}