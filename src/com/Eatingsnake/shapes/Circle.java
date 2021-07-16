package com.Eatingsnake.shapes;

import java.awt.*;

public class Circle extends ShapeofSnake {
    private int point1_x;
    private int point1_y;
    private int point2_x;
    private int point2_y;


    public Circle() {
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
