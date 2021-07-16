package com.Eatingsnake.Control;

import com.Eatingsnake.Reward;
import com.Eatingsnake.Snake;
import com.Eatingsnake.shapes.ShapeofSnake;

import javax.swing.*;
import java.util.List;

public class Controller implements Runnable {
    private int height;  // wall height
    private int width;   // wall width
    private JFrame jFrame;
    private Snake snake;   // this is a control for one snake, and this is a single game.
    private RewardControl rewardControl;

    /**
     * 每秒自动移动
     */
    public void autoMove(){
        snake.autoMove();
    }

    /**
     * 各种检测：撞墙
     * complex: N
     */
    public boolean IscrashWall(){
        ShapeofSnake head = snake.getHead();
        if(head.point1_x<0 || head.point1_x>width || head.point1_y<0 || head.point1_y>height){
            return true;
        }
        return false;
    }

    /**
     * 各种检测，撞自身 ( 自身 延伸为 其他的 snake
     * --> to finish in the future )
     * complex: N
     */
    public boolean IscrashSnake(){
        ShapeofSnake head = snake.getHead();
        List<ShapeofSnake> snakePosition = snake.getPosition();
        for(int i=1;i<snakePosition.size();i++){
            int x = snakePosition.get(i).point1_x;
            int y = snakePosition.get(i).point1_y;
            if(x==head.point1_x && y == head.point1_y){
                return true;
            }
        }
        return false;
    }
    /**
     * 吃到奖励
     */
    public boolean isCrashReward(){
        synchronized (rewardControl){
            List<Reward> rewardList = rewardControl.rewardList;
            for(int i=0; i<rewardList.size(); i++){
                Reward reward = rewardList.get(i);
                if(reward.point1_x==)
            }
        }

    }

    /**
     *
     */
    @Override
    public void run() {

    }
}
