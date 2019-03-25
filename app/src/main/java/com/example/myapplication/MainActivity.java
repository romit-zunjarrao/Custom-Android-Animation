package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add;
    ArrayList<Circle> arrayList;
    ListView list;
    CircleMotionBaseAdapter circleMotion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);

        Circle c = new Circle(dpToPx(40),dpToPx(40), Color.YELLOW);
        Log.d("color",""+Color.BLACK);
        arrayList = new ArrayList<Circle>();
        arrayList.add(c);
        list = findViewById(R.id.listView);
        circleMotion = new CircleMotionBaseAdapter(this,arrayList);
        list.setAdapter(circleMotion);
    }

    private int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, this.getResources().getDisplayMetrics());
    }

    public void addNewCircle(View view)
    {
        arrayList.add(new Circle(dpToPx(40),dpToPx(40), Color.YELLOW));
        circleMotion.notifyDataSetChanged();
    }
}
