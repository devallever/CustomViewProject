package com.allever.demo.customviewproject

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

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
//
//        drawCircle(canvas)
//
//        drawRect(canvas)
//
//        drawRoundRect(canvas)
//
//        drawOval(canvas)
//
//        drawArc(canvas)

//        drawPathDirectionFillStyle(canvas)

        drawPathWithAddXXX(canvas)

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
        canvas?.drawRoundRect(50f, 350f, 200f, 450f, 10f, 10f, mPaint)

        mPaint.style = Paint.Style.STROKE
        val rectF1 = RectF(250f, 350f, 400f, 450f)
        canvas?.drawRoundRect(rectF1, 20f, 20f, mPaint)

        mPaint.style = Paint.Style.FILL_AND_STROKE
        val rectF2 = RectF(450f, 350f, 600f, 450f)
        canvas?.drawRoundRect(rectF2, 30f, 30f, mPaint)
    }

    private fun drawOval(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 10f

        mPaint.style = Paint.Style.FILL
        canvas?.drawOval(50f, 500f, 200f, 600f, mPaint)

        mPaint.style = Paint.Style.STROKE
        val rectF1 = RectF(250f, 500f, 400f, 600f)
        canvas?.drawOval(rectF1, mPaint)

        mPaint.style = Paint.Style.FILL_AND_STROKE
        val rectF2 = RectF(450f, 500f, 600f, 600f)
        canvas?.drawOval(rectF2, mPaint)
    }

    private fun drawArc(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 5f

        mPaint.style = Paint.Style.FILL
        canvas?.drawArc(50f, 650f, 200f, 750f, 0f, -90f, false, mPaint)
        canvas?.drawArc(250f, 650f, 400f, 750f, 0f, -90f, true, mPaint)

        mPaint.style = Paint.Style.STROKE
        val rectF1 = RectF(50f, 800f, 200f, 900f)
        canvas?.drawArc(rectF1, 0f, -90f, false, mPaint)
        val rectF2 = RectF(250f, 800f, 400f, 900f)
        canvas?.drawArc(rectF2, 0f, -90f, true, mPaint)

    }

    private fun drawPathDirectionFillStyle(canvas: Canvas?) {
        val path = Path()

        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 5f

        //相交圆
        mPaint.style = Paint.Style.STROKE
        path.reset()
        path.addCircle(100f, 100f, 50f, Path.Direction.CW)
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(250f, 100f, 50f, Path.Direction.CW)
        path.addCircle(300f, 100f, 50f, Path.Direction.CW)
        canvas?.drawPath(path, mPaint)

        mPaint.style = Paint.Style.FILL
        path.reset()
        path.addCircle(100f, 250f, 50f, Path.Direction.CW)
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(250f, 250f, 50f, Path.Direction.CW)
        path.addCircle(300f, 250f, 50f, Path.Direction.CW)
        path.fillType = Path.FillType.WINDING //默认
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(450f, 250f, 50f, Path.Direction.CW)
        path.addCircle(500f, 250f, 50f, Path.Direction.CW)
        path.fillType = Path.FillType.EVEN_ODD
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(250f, 400f, 50f, Path.Direction.CW) //顺时针
        path.addCircle(300f, 400f, 50f, Path.Direction.CCW) //逆时针
        path.fillType = Path.FillType.WINDING //默认
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(450f, 400f, 50f, Path.Direction.CW)
        path.addCircle(500f, 400f, 50f, Path.Direction.CCW)
        path.fillType = Path.FillType.EVEN_ODD
        canvas?.drawPath(path, mPaint)


        //同心圆
        mPaint.style = Paint.Style.STROKE
        path.reset()
        path.addCircle(100f, 550f, 50f, Path.Direction.CW)
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(250f, 550f, 50f, Path.Direction.CW)
        path.addCircle(250f, 550f, 30f, Path.Direction.CW)
        canvas?.drawPath(path, mPaint)

        mPaint.style = Paint.Style.FILL
        path.reset()
        path.addCircle(100f, 700f, 50f, Path.Direction.CW)
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(250f, 700f, 50f, Path.Direction.CW)
        path.addCircle(250f, 700f, 30f, Path.Direction.CW)
        path.fillType = Path.FillType.WINDING //默认
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(450f, 700f, 50f, Path.Direction.CW)
        path.addCircle(450f, 700f, 30f, Path.Direction.CW)
        path.fillType = Path.FillType.EVEN_ODD
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(250f, 850f, 50f, Path.Direction.CW)
        path.addCircle(250f, 850f, 30f, Path.Direction.CCW)
        path.fillType = Path.FillType.WINDING //默认
        canvas?.drawPath(path, mPaint)

        path.reset()
        path.addCircle(450f, 850f, 50f, Path.Direction.CW)
        path.addCircle(450f, 850f, 30f, Path.Direction.CCW)
        path.fillType = Path.FillType.EVEN_ODD
        canvas?.drawPath(path, mPaint)

    }

    private fun drawPathWithAddXXX(canvas: Canvas?) {
        mPaint.reset()
        mPaint.isAntiAlias = true
        mPaint.color = resources.getColor(R.color.colorPrimary)
        mPaint.strokeWidth = 5f

        //圆形路径
        mPaint.style = Paint.Style.STROKE
        var circlePath = Path()
        circlePath.addCircle(100f, 100f, 50f, Path.Direction.CW)
        canvas?.drawPath(circlePath, mPaint)

        mPaint.style = Paint.Style.FILL
        circlePath = Path()
        circlePath.addCircle(250f, 100f, 50f, Path.Direction.CW)
        canvas?.drawPath(circlePath, mPaint)

        //矩形路径
        mPaint.style = Paint.Style.STROKE
        var rectFPath = Path()
        val rectF1 = RectF(50f, 200f, 200f, 300f)
        rectFPath.addRect(rectF1, Path.Direction.CW)
        canvas?.drawPath(rectFPath, mPaint)

        mPaint.style = Paint.Style.FILL
        rectFPath = Path()
        val rectF2 = RectF(250f, 200f, 400f, 300f)
        rectFPath.addRect(rectF2, Path.Direction.CW)
        canvas?.drawPath(rectFPath, mPaint)

        //圆角矩形路径
        mPaint.style = Paint.Style.STROKE
        var roundRectFPath = Path()
        val roundRectF1 = RectF(50f, 350f, 200f, 450f)
        roundRectFPath.addRoundRect(roundRectF1, 10f, 10f, Path.Direction.CW)
        canvas?.drawPath(roundRectFPath, mPaint)

        mPaint.style = Paint.Style.FILL
        roundRectFPath = Path()
        val roundRectF2 = RectF(250f, 350f, 400f, 450f)
        roundRectFPath.addRoundRect(roundRectF2, 10f, 10f, Path.Direction.CW)
        canvas?.drawPath(roundRectFPath, mPaint)

        //椭圆路径
        mPaint.style = Paint.Style.STROKE
        var ovalRectFPath = Path()
        val ovalRectF1 = RectF(50f, 500f, 200f, 600f)
        ovalRectFPath.addOval(ovalRectF1, Path.Direction.CW)
        canvas?.drawPath(ovalRectFPath, mPaint)

        mPaint.style = Paint.Style.FILL
        ovalRectFPath = Path()
        val ovalRectF2 = RectF(250f, 500f, 400f, 600f)
        ovalRectFPath.addOval(ovalRectF2, Path.Direction.CW)
        canvas?.drawPath(ovalRectFPath, mPaint)

        //弧形路径
        mPaint.style = Paint.Style.STROKE
        var arcRectFPath = Path()
        val arcRectF1 = RectF(50f, 650f, 200f, 750f)
        arcRectFPath.addArc(arcRectF1, 0f, -90f)
        canvas?.drawPath(arcRectFPath, mPaint)

        mPaint.style = Paint.Style.FILL
        arcRectFPath = Path()
        val arcRectF2 = RectF(250f, 650f, 400f, 750f)
        arcRectFPath.addArc(arcRectF2, 0f, -90f)
        canvas?.drawPath(arcRectFPath, mPaint)
    }

}