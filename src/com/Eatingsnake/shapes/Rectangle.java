package com.Eatingsnake.shapes;

import java.awt.*;

public class Rectangle extends ShapeofSnake {
    private int point1_x;
    private int point1_y;
    private int point2_x;
    private int point2_y;

    public Rectangle(int point1_x, int point1_y, int point2_x, int point2_y) {
        this.point1_x = point1_x;
        this.point1_y = point1_y;
        this.point2_x = point2_x;
        this.point2_y = point2_y;
    }

    @Override
    public void draw(Graphics g){
        int x = point1_x;
        int y = point1_y;
        int width = point2_x - point1_x;
        int height = point2_y - point1_y;

        g.drawRect(x,y,width,height);
    }
}
