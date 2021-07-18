package exercise;

public class Threadtest {
    public static void main(String[] args) {
        Student s = new Student();
        thread3 t3 = new thread3(s);
        new thread2(s,t3);

    }
}

class Student{
    public int age;

    public void put(int age){
        this.age = age;
    }

    public void getAge(){
        System.out.println(age);
    }
}

class thread2 implements Runnable{
    private Student student;
    private thread3 thread3;
    int number = 0;

    public thread2(Student student, thread3 t3) {
        this.student = student;
        thread3 = t3;
        Thread t = new Thread(this, "thread1");
        t.start();
    }

    public void addAge(){

        student.put(number++);
        System.out.println("set age  "+ student.age);
    }
    public void callT3(){
        System.out.println("this is in t2, and it call t3 thread's function");
        thread3.getAge();
    }


    @Override
    public void run() {
        while(true){
            addAge();
            callT3();
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class thread3 implements Runnable{

    private Student student;

    public thread3(Student student) {
        this.student = student;
        Thread t = new Thread(this, "thread2");
        t.start();
    }

    public void getAge(){
       System.out.println("get age :   "+student.age);
    }

    @Override
    public void run() {
        while(true){
            getAge();
            try {
                Thread.sleep(5000);
                System.out.println("thread2 run() function....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
