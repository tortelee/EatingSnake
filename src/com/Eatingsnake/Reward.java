package com.Eatingsnake;

import com.Eatingsnake.shapes.ShapeofSnake;

public class Reward extends ShapeofSnake {
    private int count;

    public Reward() {
    }

    public Reward(int count) {
        this.count = count;
    }

    public Reward(int point1_x, int point1_y, int count) {
        super(point1_x, point1_y, 10, 10);     // 可以更好的调制下
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
