package exercise;

import com.Eatingsnake.Reward;

import java.util.ArrayList;
import java.util.List;

public class objectAA {
    public static void main(String[] args) {
        List<Reward> s = new ArrayList<>();
        s.add(new Reward(1));
        s.add(new Reward(3));
        s.add(new Reward(6));
        try {
            method(s);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T> void method(List<T> objects) throws InstantiationException, IllegalAccessException {
        for(int i=0;i<objects.size();i++){
            Class zz = objects.get(i).getClass();

            T obj = (T) objects.get(i).getClass().newInstance();

        }
    }
}
