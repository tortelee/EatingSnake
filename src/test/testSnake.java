package test;

import com.Eatingsnake.MoveStrage;
import com.Eatingsnake.MoveStrageSingleFactory;
import com.Eatingsnake.Reward;
import com.Eatingsnake.Snake;

public class testSnake {

    public static void main(String[] args) {
        Snake snake = Snake.getInstance();
        Reward reward = new Reward(3);
        snake.eat(reward);
        System.out.println(snake.toString());

        System.out.println("testing moving stragy.....");
        MoveStrage m1 = MoveStrageSingleFactory.getMove("up");
        MoveStrage m2 = MoveStrageSingleFactory.getMove("down");
        MoveStrage m3 = MoveStrageSingleFactory.getMove("left");
        MoveStrage m4 = MoveStrageSingleFactory.getMove("right");

        snake.move(m1);
        System.out.println(snake.toString());
        snake.move(m2);
        System.out.println(snake.toString());
        snake.move(m3);
        System.out.println(snake.toString());
        snake.move(m4);
        System.out.println(snake.toString());


    }
}
