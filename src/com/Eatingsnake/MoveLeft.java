package com.Eatingsnake;

public class MoveLeft implements MoveStrage {

    @Override
    public int[] offset() {
        return new int[]{-1,0};
    }
}
