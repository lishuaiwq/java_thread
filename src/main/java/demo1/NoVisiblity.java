package demo1;

import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.TimeUnit;


public class NoVisiblity {
    @GuardedBy("this") private volatile static  boolean ready = false;
    private volatile static int number = 1;
    public synchronized static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i);
            }
        }).start();
        new Thread(() -> {
            System.out.println("执行线程中......");
            while(!ready){
                Thread.yield();
                System.out.println("hahah"+number);
            }
            System.out.println("执行结束....");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        number = 42;
       ready =true;


    }
}
