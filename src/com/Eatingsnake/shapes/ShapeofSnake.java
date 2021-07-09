package com.Eatingsnake.shapes;

import java.awt.*;

public class ShapeofSnake {
    public int point1_x;
    public int point1_y;
    public  int point2_x;
    public int point2_y;

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

    public int getPoint2_x() {
        return point2_x;
    }

    public void setPoint2_x(int point2_x) {
        this.point2_x = point2_x;
    }

    public int getPoint2_y() {
        return point2_y;
    }

    public void setPoint2_y(int point2_y) {
        this.point2_y = point2_y;
    }

    public int getWidth(){
        return point2_x - point1_x;
    }

    public int getHeight(){
        return point2_y - point1_y;
    }

    public void draw(Graphics g){

    }
}
