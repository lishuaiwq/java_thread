package demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NumAddUtil {
private static int num = 0;
   private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static int add(int a) throws InterruptedException {
        num = a;
        threadLocal.set(num);
        TimeUnit.SECONDS.sleep( 1);
        return threadLocal.get()+10;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for( int i =0 ;i <20 ;i++){
            int num = i;
            executorService.execute(()-> {
                try {
                    System.out.println(num + ":"+ NumAddUtil.add(num));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
