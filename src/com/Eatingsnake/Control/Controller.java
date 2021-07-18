package com.Eatingsnake.Control;

import com.Eatingsnake.MoveStrage;
import com.Eatingsnake.MoveStrageSingleFactory;
import com.Eatingsnake.Reward;
import com.Eatingsnake.Snake;
import com.Eatingsnake.shapes.ShapeofSnake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Logger;

public class Controller implements Runnable {
    private Logger logger = Logger.getLogger("snake");
    private int height;  // wall height
    private int width;   // wall width
    private JFrame jFrame;
    private Snake snake;   // this is a control for one snake, and this is a single game.
    private RewardControl rewardControl;

    public Controller(JFrame jFrame, Snake snake, RewardControl rewardControl) {
        this.jFrame = jFrame;
        this.snake = snake;
        this.rewardControl = rewardControl;
        this.height = this.jFrame.getHeight();
        this.width = this.jFrame.getWidth();

    }

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
    public Reward isCrashReward(){
        Reward res = null;
        synchronized (rewardControl){
            List<Reward> rewardList = rewardControl.rewardList;
            ShapeofSnake head = snake.getHead();
            for(int i=0; i<rewardList.size(); i++){
                Reward reward = rewardList.get(i);
                if(reward.point1_x==head.point1_x && reward.point1_y == head.point1_y){
                    res = reward;
                }
            }
        }
        return res;
    }

    /**
     * 响应键盘事件.
     * 线程直接被主线程调用？ 合理么？
     * 是合理的，根据分析
     * 1,将鼠标信息同步给snake这些 // 改变direction
     *
     */
    public void responseKey(KeyEvent keyEvent){
        if(keyEvent==null){
            return;
        }
        int keycode = keyEvent.getKeyCode();
        switch (keycode){
            case(KeyEvent.VK_W):
                if(snake.canChange(new int[]{0,-1})) {
                    snake.setDirection(new int[]{0, -1});
                }
                break;
            case(KeyEvent.VK_S):
                if(snake.canChange(new int[]{0,1})) {
                    snake.setDirection(new int[]{0, 1});
                }
                break;
            case(KeyEvent.VK_A):
                if(snake.canChange(new int[]{-1,0})) {
                    snake.setDirection(new int[]{-1, 0});
                }
                break;
            case(KeyEvent.VK_D):
                if(snake.canChange(new int[]{1,0})) {
                    snake.setDirection(new int[]{1, 0});
                }
                break;
        }

    }


    /**
     *
     */
    @Override
    public void run(){

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            snake.autoMove();
        }


    }
}
