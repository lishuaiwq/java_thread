package demo1;

import java.util.ArrayList;
import java.util.concurrent.*;

public class SimpleThread {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /***
         * 线程得基本创建方式1，继承Thread重写其中得runf方法
         */
        new Thread(){
            @Override
            public void run() {
                System.out.println("基础创建线程方式1");
            }
        }.start();

        /***
         * 线程得基本创建方式1，lambad写法
         */
        new Thread(()-> System.out.println("基础创建线程的方式1变种"));


        ///////////////////创建的线程没有返回值
        Runnable thread = () -> System.out.println("基础创建线程的方式2");
        new Thread(thread).start();


        ////////////////////////////
        /****
         * 基础创建
         */
        FutureTask<String> futureTask = new FutureTask( new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "hehe";
            }
        });
        futureTask.run();
        String o = futureTask.get();
        System.out.println(o);
    }
}
