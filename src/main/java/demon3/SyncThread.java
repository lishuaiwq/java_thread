package demon3;

import java.util.concurrent.CountDownLatch;

public class SyncThread implements Runnable {
    private static int count = 10;

    final static CountDownLatch countDownLatch = new CountDownLatch(1);
    @Override
    public  synchronized void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0;i< 10;i++){
            if(count > 0){
                System.out.println(Thread.currentThread().getName() + ":" + (count--));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
/*        new Thread(new SyncThread()).start();
        new Thread(new SyncThread()).start();
        new Thread(new SyncThread()).start();*/
        String c = "\\001";
        System.out.println(c);
        String a = "dasdasdasd.json";
        System.out.println(a.substring(0,a.indexOf(".")));
    }
}
