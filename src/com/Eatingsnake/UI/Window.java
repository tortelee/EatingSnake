package com.Eatingsnake.UI;

import com.Eatingsnake.Control.Controller;
import com.Eatingsnake.Snake;
import com.Eatingsnake.shapes.ShapeofSnake;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

public class Window extends JFrame {
    private Logger logger = Logger.getLogger("snake");
    private Controller controler;
    public Snake snake;   // 以后将会被删去

    private Color[] colors = new Color[10];
    private static int count = 0;

    public Window() throws HeadlessException {
        colors[0] = Color.BLACK;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
    }

    public Controller getControler() {
        return controler;
    }

    public void setControler(Controller controler) {
        this.controler = controler;
    }

    public void paintRect(Graphics g, ShapeofSnake shape){
        if(count==Integer.MAX_VALUE){
            count = 0;
        }
        count++;

        int z = count - (count/3)*3;
        String colo = colors[z] + "";
        logger.info("color is "+ colo);
        logger.info("position is "+ shape.point1_x+" " +shape.point1_y);
        g.setColor(colors[z]);
       // g.setColor(Color.BLACK);
        shape.draw(g);    //具体怎么画，由rect类决定
    }

    public void paintSnake(Graphics g, Snake s){
        if(s==null){
            logger.info("the input snake is null");
        }
        List<ShapeofSnake> pos = s.getPosition();

        String msg = "snake size is "+pos.size();
        logger.info(msg);

        for (ShapeofSnake shape:pos
             ) {
            paintRect(g,shape);
        }
    }

    /**
     * 画边界
     * 画蛇
     * 画
     * @param g
     */
    @Override
    public void paint(Graphics g){
        paintSnake(g,snake);
    }

    public static void main(String[] args) {
        Window frame = new Window();

        frame.setSize(600, 600);
        frame.setUndecorated(false);//true去掉窗口框！
        frame.setTitle("俄罗斯方块");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Location 位置 RelativeTo相对于
        frame.setLocationRelativeTo(null);//使当前窗口居中
        frame.setVisible(true);



        // set and get
       // frame.getM().setMyRectangle(frame.r);
        Snake snake2 = Snake.getInstance();
        if(snake2!=null){
            System.out.println("snake2 from windows main is not null");
        }

        frame.snake = snake2;

        frame.repaint();

        //     frame.add(new Button("ok"));

        //    frame.addMouseListener(m);
        frame.requestFocus();
    }
}
