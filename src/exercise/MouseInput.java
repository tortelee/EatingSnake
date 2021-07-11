package exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

/**
 * 这个是表现层，将逻辑层处理的好的，画出来
 * 1，给逻辑层怎么给？ 逻辑层决定画什么，但是怎么画在这里
 *  因此这里提供一些基本的画图功能，可以方便逻辑层画
 *  2，如果这边画，画的物体涉及，背景，框，蛇。
 *  3，涉及 报错响应信息； 涉及开始和结束的控制按钮
 *  4，当点击这些按钮时，发送的消息是从表现层发的？ 并不是，
 *  这是由listener 监控线程处理的
 */
public class MouseInput extends JFrame {
    Logger l = Logger.getLogger("test");

    MyRectangle r  = new MyRectangle(100,70,40,40);

    MyMouseAdapter m = new MyMouseAdapter();

    public MouseInput() throws HeadlessException {
        this.addMouseListener(m);
        m.setjFrame(this);
    }

    public MyRectangle getR() {
        return r;
    }

    public void setR(MyRectangle r) {
        this.r = r;
    }

    public MyMouseAdapter getM() {
        return m;
    }

    public void setM(MyMouseAdapter m) {
        this.m = m;
    }

    @Override
    public void paint(Graphics g){
      //  l.info("begin painting rectangle");
        if(!r.isIn){
            l.info("painting    black");
            g.setColor(Color.BLACK);
            g.fillRect(r.x,r.y,r.width,r.height);
        }else{
            l.info("painting red");
            g.setColor(Color.RED);
            g.fillRect(r.x,r.y,r.width,r.height);
        }
    }
    public static void main(String[] args) {

        MouseInput frame = new MouseInput();

        frame.setSize(525, 590);
        frame.setUndecorated(false);//true去掉窗口框！
        frame.setTitle("俄罗斯方块");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Location 位置 RelativeTo相对于
        frame.setLocationRelativeTo(null);//使当前窗口居中
        frame.setVisible(true);


        // set and get
        frame.getM().setMyRectangle(frame.r);


        frame.repaint();

   //     frame.add(new Button("ok"));

    //    frame.addMouseListener(m);
        frame.requestFocus();

    }
}

/**
 * 这个是读取鼠标信息的，并且对鼠标事件进行响应。
 * 具体对鼠标事件的响应，可以放在这里。（如果放在这里，那么鼠标信息就在这里截止，handle）
 * 也可以以callback形式出现,那么就是以其他的形式将这个信息传递下去 Event e。preferred
 * 1，mouse click 要传给逻辑层
 */

class MyMouseAdapter extends MouseAdapter {

    Logger l = Logger.getLogger("test");
    private MyRectangle myRectangle;
    private JFrame jFrame;

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public MyRectangle getMyRectangle() {
        return myRectangle;
        }

    public void setMyRectangle(MyRectangle myRectangle) {
        this.myRectangle = myRectangle;
        }

    /**
     * 放在这里是不合适的，需要在单独的类，处理这个逻辑
     * @param event
     */
    public void updateIsIn(MouseEvent event){
        int x = event.getX();
        int y = event.getY();
        myRectangle.setIn(x,y);
        jFrame.repaint();
        }

    /**
     * 这里应该通知mediator,mouse有事件触发
     * 并将event事件传过去
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        updateIsIn(e);

        int x = e.getX();
        int y = e.getY();
        String information = "x: "+ x +" y: "+ y;
        l.info(information);
        super.mouseClicked(e);
        }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
        }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        }
        };

/**
 * 这个是 snake,只根据命令进行，移动等
 */
class MyRectangle {

    int x;
    int y;
    int width;
    int height;
    boolean isIn = false;
    Logger l = Logger.getLogger("test");

    public MyRectangle() {
    }

    public MyRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setIn(int cursor_x, int cursor_y) {
        l.info("the cursor is in the component");
        if(cursor_x>=x && cursor_x<= (x+width) && cursor_y>y && cursor_y< (y+height)){
            isIn = true;
        }else{
            isIn = false;
        }
    }

    // 通过外加参数 控制画的东西过程

    public void paintRect(Graphics g){
        l.info("the rectangle component is repainting...");
        g.setColor(Color.BLACK);
        g.drawRect(x,y,20,20);
        if(isIn){
            g.fillRect(x,y,width,height);
        }
    }
}
