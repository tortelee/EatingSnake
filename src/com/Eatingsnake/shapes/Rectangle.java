package com.Eatingsnake.shapes;

import java.awt.*;
import java.util.logging.Logger;

public class Rectangle extends ShapeofSnake {
    Logger logger = Logger.getLogger("snake");

    public Rectangle() {
        logger.info("rectangle is created...");
    }

    public Rectangle(int point1_x, int point1_y, int width, int height) {
        this.point1_x = point1_x;
        this.point1_y = point1_y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g){
        int x = point1_x;
        int y = point1_y;
        g.fillRect(x,y,width,height);
    }
}
