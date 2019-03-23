package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class CircleAnimationView extends View {

    Paint mPaint;
    Circle circle;
    float x;
    boolean directionLeft;
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
        directionLeft = true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //canvas.drawCircle(getWidth()/2,getHeight()/2,circle.circleRadius,mPaint);
        drawCircle(canvas);
    }

    public void drawCircle(Canvas canvas)
    {
        canvas.drawCircle( x,getHeight()/2,circle.circleRadius,mPaint);
        if(x+circle.circleRadius<=getWidth())
        {
            directionLeft = true;
        }
        else
        {
            directionLeft = false;
        }

    }

    private int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getContext().getResources().getDisplayMetrics());
    }
}


