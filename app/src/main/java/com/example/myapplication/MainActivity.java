package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Circle c = new Circle(dpToPx(40),dpToPx(40), Color.BLACK);
        ArrayList<Circle> arrayList = new ArrayList<Circle>();
        arrayList.add(c);
        ListView list = findViewById(R.id.listView);
        CircleMotionBaseAdapter circleMotion = new CircleMotionBaseAdapter(this,arrayList);
        list.setAdapter(circleMotion);
    }

    private int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, this.getResources().getDisplayMetrics());
    }
}
