package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.logging.Handler;

public class CircleAnimationView extends View {

    Paint mPaint;
    Circle circle;
    float x;
    boolean touchWidthMax, touchWidthMin;
    public CircleAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.circle);
        circle = new Circle(typedArray.getDimension(R.styleable.circle_circleRadius,dpToPx(5)),typedArray.getDimension(R.styleable.circle_circleSpeed,dpToPx(10)),
                typedArray.getColor(R.styleable.circle_circleColor,Color.GREEN));
        typedArray.recycle();
        initPaint();
    }

    public void initPaint()
    {
        mPaint = new Paint();
        mPaint.setColor(circle.circleColor);
        x = circle.circleRadius;
        touchWidthMax = false;
        touchWidthMin = true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        drawCircle(canvas);
    }

    public void drawCircle(Canvas canvas)
    {
        if(touchWidthMax == false)
        {
            invalidate();
            mPaint.setColor(circle.circleColor);
            canvas.drawCircle( x = x + circle.circleSpeed,getHeight()/2,circle.circleRadius,mPaint);
            if(x+circle.circleSpeed >= getWidth()-dpToPx(10))
            {
                touchWidthMin = false;
                touchWidthMax = true;
            }
        }
        else if(touchWidthMin == false)
        {
            invalidate();
            mPaint.setColor(circle.circleColor);
            canvas.drawCircle( x=x - circle.circleSpeed,getHeight()/2,circle.circleRadius,mPaint);
            if(x-circle.circleSpeed <= circle.circleRadius)
            {
                touchWidthMin = true;
                touchWidthMax = false;
            }
        }


    }

    private int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getContext().getResources().getDisplayMetrics());
    }

    public void setCircle(float radius, float speed, int color )
    {
        circle = new Circle(radius,speed,color);
    }
}


