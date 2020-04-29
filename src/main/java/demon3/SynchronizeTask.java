package demon3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class SynchronizeTask{

    private static int a = 5;

    private  void increase() throws InterruptedException {
        System.out.println("开始卖票");
        if(a > 0){
            System.out.println("卖出"+ a--);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CountDownLatch countDownLatch1 = new CountDownLatch(10);

        SynchronizeTask synchronizeTask = new SynchronizeTask();
        for(int i = 0;i<10;i++){
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    synchronizeTask.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch1.countDown();
                }
            }).start();
        }
        for(int i=0;i<5;i++){
            Thread.sleep(1000);
            System.out.println(i+1+"秒");
        }
        System.out.println("=======开始放行======");
        countDownLatch.countDown();
        System.out.println("=======期待结果===");
        countDownLatch1.await();

        System.out.println();
        System.out.println(a);
    }
}
