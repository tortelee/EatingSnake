import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SnakeJapanel extends JPanel {

    private static Image background1;
    private static Image background2;
    public boolean flag;
    static {
        try {
            //  relative path is better
            background1 = ImageIO.read(new File("F:\\EatingSnake\\src\\static\\background.jpg"));
            background2 = ImageIO.read(new File("F:\\EatingSnake\\src\\static\\qw.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void action(){
        while(true){
            try {
                Thread.sleep(1000);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void paint(Graphics g){
        if(flag){
            paintBackground(g,background1);
            flag = false;
        }else{
            paintBackground(g,background2);
            flag = true;
        }
    }



    private void paintBackground(Graphics g,Image image){
        g.drawImage(image,0,0,null);
    }

    public static void main(String[] args) {
        SnakeJapanel s = new SnakeJapanel();

        JFrame frame = new JFrame();
        frame.add(s);

        frame.setVisible(true);

        s.action();


    }
}
