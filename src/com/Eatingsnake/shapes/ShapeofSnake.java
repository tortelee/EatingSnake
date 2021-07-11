package com.Eatingsnake.shapes;

import java.awt.*;

public class ShapeofSnake {
    public int point1_x;
    public int point1_y;
    public  int width;
    public int height;

    public ShapeofSnake() {
    }

    public ShapeofSnake(int point1_x, int point1_y, int width, int height) {
        this.point1_x = point1_x;
        this.point1_y = point1_y;
        this.width = width;
        this.height = height;
    }

    public int getPoint1_x() {
        return point1_x;
    }

    public void setPoint1_x(int point1_x) {
        this.point1_x = point1_x;
    }

    public int getPoint1_y() {
        return point1_y;
    }

    public void setPoint1_y(int point1_y) {
        this.point1_y = point1_y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public void draw(Graphics g){

    }
}
