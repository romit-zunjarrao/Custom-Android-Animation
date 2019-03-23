package com.example.myapplication;

public class Circle {
    float circleRadius;
    float circleSpeed;
    int circleColor;


    @Override
    public String toString() {
        return "Circle{" +
                "circleRadius=" + circleRadius +
                ", circleSpeed=" + circleSpeed +
                ", circleColor=" + circleColor +
                '}';
    }

    public float getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(float circleRadius) {
        this.circleRadius = circleRadius;
    }

    public float getCircleSpeed() {
        return circleSpeed;
    }

    public void setCircleSpeed(float circleSpeed) {
        this.circleSpeed = circleSpeed;
    }

    public int getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
    }

    public Circle(float circleRadius, float circleSpeed, int circleColor) {
        this.circleRadius = circleRadius;
        this.circleSpeed = circleSpeed;
        this.circleColor = circleColor;
    }
}
