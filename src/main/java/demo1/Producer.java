package demo1;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer {

    private static final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) {
              //给队列添加任务

             new Thread(()->{
                 int i=0;
                 while (true) {
                     System.out.println("生产者生产任务："+i);
                     taskQueue.offer(()-> System.out.println(new Random().nextInt()));
                     System.out.println("生产者生产任务结束："+i++);
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }).start();


        List<Thread> cusermer = Lists.newArrayList();
        for(int i=0;i<5;i++){
            cusermer.add(new Thread("线程" + i));
        }


        while (true){
            for(int i=0;i<5;i++){
                cusermer.get(i).run();
            }
        }

    }
}
