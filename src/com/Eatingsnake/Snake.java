package com.Eatingsnake;

import com.Eatingsnake.shapes.Rectangle;
import com.Eatingsnake.shapes.ShapeofSnake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Snake {
    private Logger logger = Logger.getLogger("snake");
    private String name;
    private List<ShapeofSnake> position ;
    private List<int[]> colors = new ArrayList<>();
    private boolean status;
    private static int[] direction;
    private static Snake snake;


    public Snake() {
        name = "default snake";
        position = new ArrayList<ShapeofSnake>();
        this.addShape(new Rectangle(30,30,30,30));
        this.addShape(new Rectangle(60,30,30,30));
        this.addShape(new Rectangle(90,30,30,30));
        this.addShape(new Rectangle(120,30,30,30));
    }

    public Snake(String name, List<ShapeofSnake> position) {

        this.name = name;
        this.position = position;
        this.direction = new int[]{1,1};
    }
    @Override
    public String toString(){
        StringBuffer br = new StringBuffer("");
        for (ShapeofSnake s:position
             ) {
            br.append(s.point1_x+" " + s.point1_y + " " + s.width + " " + s.height + "\n");
        }
        return br.toString();
    }




    public String getName() {
        return name;
    }

    public List<ShapeofSnake> getPosition() {
        return position;
    }

    public void addShape(ShapeofSnake ss){
        position.add(ss);
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

    /**
     * 1，吃的话，前面延长一些，加一些位置。
     * 在list 中，前头加一个。 这个不如Linklist效率高
     * 2， 增加一个新的对象。 未来可以用多粒度模式取代吧
     * 新对象利用反射
     *
     * @param reward
     */
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
                shapeofSnake.draw(Graphics.class.newInstance());
                shapeofSnake.setPoint1_x(x1);
                shapeofSnake.setPoint1_y(y1);
                shapeofSnake.setWidth(x1+width);
                shapeofSnake.setHeight(y1+height);
                position.add(0,shapeofSnake);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 写的很丑，
     *
     * @param moveStrage
     * @throws Exception
     */
    public void move(MoveStrage moveStrage)  {
        if(moveStrage.offset().length !=2){
            logger.info("the offset length is not correct");
            return;
        }
        int offset_0 = moveStrage.offset()[0];
        int offset_1 = moveStrage.offset()[1];
        // record the first
        int x1 = position.get(0).getPoint1_x();
        int y1 = position.get(0).getPoint1_y();
        int z1 = position.get(0).getWidth();
        int z2 = position.get(0).getHeight();
        //o(N) move
        for(int i=1;i<position.size();i++){
            position.get(i).setPoint1_x(position.get(i-1).getPoint1_x());
            position.get(i).setPoint1_y(position.get(i-1).getPoint1_y());
            position.get(i).setWidth(position.get(i-1).getWidth());
            position.get(i).setHeight(position.get(i-1).getHeight());
        }
        int new_x1 = x1 + moveStrage.offset()[0];
        int new_y1 = y1 + moveStrage.offset()[1];
        // first move
        position.get(0).setPoint1_x(new_x1);
        position.get(0).setPoint1_y(new_y1);
        position.get(0).setWidth(new_x1+position.get(0).getWidth());
        position.get(0).setHeight(new_y1+position.get(0).getHeight());
    }

    public static Snake getInstance(){

        if(snake==null){
            System.out.println("create object");
            snake= new Snake();
        }

        if(snake==null){
            System.out.println("create object failed");
        }
        if(snake==null){
            System.out.println("create object failed");
        }
        return snake;
    }

    public static void main(String[] args) {
        Snake zz = Snake.getInstance();
        System.out.println(zz.name);
        System.out.println(zz.getPosition().get(0).point1_x);
        System.out.println(zz.toString());
        zz.eat(new Reward(1));
    }
}

