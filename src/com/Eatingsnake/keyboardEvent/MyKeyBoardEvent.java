package com.Eatingsnake.keyboardEvent;

import com.Eatingsnake.MoveStrageSingleFactory;
import com.Eatingsnake.Snake;
import com.Eatingsnake.UI.Window;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

/**
 * 感觉用观察者模式比较好，
 * 鼠标的观察者有： Jframe 的component
 * snake类出现在这里 显然不合适
 *
 */
public class MyKeyBoardEvent extends KeyAdapter {
    Logger logger = Logger.getLogger("snake");
    private Window jFrame;

    public MyKeyBoardEvent(Window jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        logger.info(""+keycode);
        jFrame.responseMouse(e);

    }

    }
