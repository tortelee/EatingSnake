package com.Eatingsnake;

public class MoveDown implements MoveStrage{
    @Override
    public int[] offset() {
        return new int[]{0,-1};
    }
}
