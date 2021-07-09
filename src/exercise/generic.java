package exercise;

import java.util.ArrayList;
import java.util.List;

public class generic<T> {
    private List<T> genetics;

    public generic(List<T> genetic) {
        this.genetics = genetic;
    }

    public List<T> getGenetics() {
        return genetics;
    }

    public void setGenetics(List<T> genetics) {
        this.genetics = genetics;
    }

    public void print(){
        for (T t:genetics
             ) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> helo = new ArrayList<>();
        helo.add("ae");
        helo.add("ae23");
        helo.add("ae12");
        generic g = new generic(helo);
        g.print();
        ArrayList<Integer> heloINT = new ArrayList<>();
        heloINT.add(1);
        heloINT.add(2);
        heloINT.add(3);

        g.setGenetics(heloINT);
        g.print();



    }
}
