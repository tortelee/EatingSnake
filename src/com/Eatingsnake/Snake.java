package com.Eatingsnake;

import com.Eatingsnake.shapes.ShapeofSnake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Snake<T> {
    private Logger logger = Logger.getLogger("snake");
    private String name;
    private List<ShapeofSnake> position ;
    private List<int[]> colors = new ArrayList<>();
    private boolean status;
    private static int[] direction;

    public Snake() {
    }

    public Snake(String name, List<ShapeofSnake> position) {

        this.name = name;
        this.position = position;
        this.direction = new int[]{1,1};
    }


    public String getName() {
        return name;
    }

    public List<ShapeofSnake> getPosition() {
        return position;
    }

    public List<int[]> getColors() {
        return colors;
    }

    public boolean isStatus() {
        return status;
    }

    public void setDirection(int[] dirct){
        if(dirct.length!=2){
            logger.info("give wrong direction : {}");
            return;
        }
        direction[0] = dirct[0];
        direction[1] = dirct[1];

    }


    public void eat(Reward reward){
        int increments = reward.getCount();
        for(int i=0;i<increments;i++){
            int x1 = position.get(0).point1_x;
            int y1 = position.get(0).point1_y;
            int width = position.get(0).getWidth();
            int height = position.get(0).getHeight();
            Class c =  position.get(0).getClass();
            try {
                ShapeofSnake shapeofSnake = (ShapeofSnake) c.newInstance();
                shapeofSnake.setPoint1_x(x1);
                shapeofSnake.setPoint1_y(y1);
                shapeofSnake.setPoint2_x(x1+width);
                shapeofSnake.setPoint2_y(y1+height);

                position.add(0,shapeofSnake);


            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }
    }

    public void move(MoveStrage moveStrage) throws Exception {
        if(moveStrage.offset().length !=2){
            throw new Exception("the offset length is not correct");
        }
        int offset_0 = moveStrage.offset()[0];
        int offset_1 = moveStrage.offset()[1];
        // update the position.
    //    int[] first = new int[]{offset_0+position.get(0)[0],offset_1+position.get(0)[1]};
        int length = position.size();
        position.remove(length-1);
     //   position.add(0,first);
    }
}

