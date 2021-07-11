package com.Eatingsnake.keyboardEvent;

import com.Eatingsnake.MoveStrageSingleFactory;
import com.Eatingsnake.Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 感觉用观察者模式比较好，
 * 鼠标的观察者有： Jframe 的component
 * snake类出现在这里 显然不合适
 *
 */
public class MyKeyBoardEvent extends KeyAdapter {




    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            System.exit(0);//退出当前的Java进程
        }
        //否则处理其它按键
        switch(key){
            case KeyEvent.VK_RIGHT: ; break;
       //     case KeyEvent.VK_LEFT: snake.move(MoveStrageSingleFactory.getMove("left")); break;
        //    case KeyEvent.VK_DOWN: snake.move(MoveStrageSingleFactory.getMove("down"));  break;
        //    case KeyEvent.VK_UP: snake.move(MoveStrageSingleFactory.getMove("up"));  break;
          //  case KeyEvent.VK_Z: rotateLeftAction() ; break;
          //  case KeyEvent.VK_SPACE: hardDropAction() ; break;
         //    case KeyEvent.VK_P: pauseAction() ; break;
    }

   }
    }
