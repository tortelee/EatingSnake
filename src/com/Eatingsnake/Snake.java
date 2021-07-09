package com.Eatingsnake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Snake<T> {
    private Logger logger = Logger.getLogger("snake");
    private String name;
    private List<T> position ;
    private List<int[]> colors = new ArrayList<>();
    private boolean status;
    private static int[] direction;

    public Snake(String name, List<int[]> position) {

        this.name = name;
     //   this.position = position;
        this.direction = new int[]{1,1};
    }


    public String getName() {
        return name;
    }

   // public List<int[]> getPosition() {
     //   return position;
  //  }

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
        //    int x1 = position.get(0)[0];
        //    int y1 = position.get(0)[1];
        //    position.add(0,new int[]{x1+direction[0],y1+direction[1]});
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

