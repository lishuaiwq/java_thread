package demo1;

import java.util.ArrayList;
import java.util.concurrent.*;

public class SimpleThread {


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        new Thread(() -> {
            for(int i = 0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("1");
            }
        }).start();
        new Thread(() -> System.out.println("2")).start();


        ArrayList list = new ArrayList();
        Thread thread = new Thread(() -> System.out.println("1"));

        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            Thread.sleep(3000);
           return "nihao";
        });


        Thread thread1 = new Thread(futureTask);
        thread1.start();
        String s = futureTask.get(3, TimeUnit.SECONDS);
        System.out.println(s);
    }
}
