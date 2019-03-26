package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add;
    ArrayList<Circle> arrayList;
    ListView list;
    CircleMotionBaseAdapter circleMotion;
    int selectedColor;
    EditText speedEditText, radiusEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);

        speedEditText = findViewById(R.id.speedEditText);
        radiusEditText = findViewById(R.id.radiusEditText);
        arrayList = new ArrayList<Circle>();
        list = findViewById(R.id.listView);
        circleMotion = new CircleMotionBaseAdapter(this,arrayList);
        list.setAdapter(circleMotion);
    }

    private int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, this.getResources().getDisplayMetrics());
    }

    public void addNewCircle(View view)
    {
        if(isEmpty()) {
            int radius, speed;
            radius = Integer.parseInt(radiusEditText.getText().toString());
            speed = Integer.parseInt(speedEditText.getText().toString());
            Log.d("circle value", radius + "" + speed + " " + selectedColor);
            arrayList.add(new Circle(dpToPx(radius), dpToPx(speed), selectedColor));
            circleMotion.notifyDataSetChanged();
        }
        radiusEditText.setText("");
        speedEditText.setText("");
        selectedColor=0;
    }


    public void colorSelected(View view)
    {
        Log.d("Color selected",""+((ColorDrawable)view.getBackground()).getColor());
        selectedColor = ((ColorDrawable)view.getBackground()).getColor();
    }


    public boolean isEmpty()
    {
        if(radiusEditText.getText().length()<=0) {
            Toast.makeText(this, "Radius should be Greater then 1", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(speedEditText.getText().length()<=0 || Integer.parseInt(speedEditText.getText().toString()) <= 1)
        {
            Toast.makeText(this,"Speed should be greater then 0",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(selectedColor == 0)
        {
            Toast.makeText(this,"Select A color",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
}
