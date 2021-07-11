package com.Eatingsnake;

public class MoveStrageSingleFactory {
    private static MoveDown moveDown;
    private static MoveUp moveUp;
    private static MoveLeft moveLeft;
    private static MoveRight moveRight;

    public static MoveStrage getMove(String moveTo){
        if(moveTo.equals("up")){
            if(moveUp==null){
                moveUp = new MoveUp();
            }
            return moveUp;
        }

        if(moveTo.equals("down")){
            if(moveDown==null){
                moveDown = new MoveDown();
            }
            return moveDown;
        }

        if(moveTo.equals("left")){
            if(moveLeft==null){
                moveLeft = new MoveLeft();
            }
            return moveLeft;
        }

        if(moveTo.equals("right")){
            if(moveRight==null){
                moveRight = new MoveRight();
            }
            return moveRight;
        }
        return null;
    }
}
