package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CircleMotionBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList arrayList;

    public CircleMotionBaseAdapter(Context context, ArrayList list) {
        this.context = context;
        this.arrayList = list;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
            holder.circleAnimationView = convertView.findViewById(R.id.CircleAnimationView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        CircleAnimationView cav = holder.circleAnimationView ;//convertView.findViewById(R.id.CircleAnimationView);
        Circle c = (Circle)arrayList.get(position);
        cav.setCircle(c.circleRadius,c.circleSpeed,c.circleColor);
        return convertView;
    }

    class ViewHolder
    {
        CircleAnimationView circleAnimationView;

    }
}
