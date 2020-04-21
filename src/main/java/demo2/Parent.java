package demo2;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parent {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try{
             for(int i=0;i<5;i++){
                 System.out.println("睡眠"+i+"秒");
                 Thread.sleep(1000);
             }
            }catch (Exception e){

            }finally {
                countDownLatch.countDown();
            }
        }).start();

        System.out.println("主线程执行");
        try {
            /**等6秒如果没有减为0则主动超时**/
            if(countDownLatch.await(2, TimeUnit.SECONDS)){
                System.out.println("主线程通过大门");
            }else {
                System.out.println("超时");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        fun1("a","b","c");
    }

    public void fun(int a ){
        if(a <10){
            throw new RuntimeException("hehe");
        }
    }

    public static void fun1(String ...key){
        System.out.println(key);
        for(int i = 0;i<key.length;i++){
            if(key[i] instanceof String){
                System.out.println("类型没问题");
            }
            System.out.println(key[i]);
        }
    }
}
