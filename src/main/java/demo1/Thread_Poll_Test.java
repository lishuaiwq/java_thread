package demo1;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Thread_Poll_Test {
   public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16,
            120, TimeUnit.SECONDS, new LinkedBlockingQueue<>(120));

    public static void main(String[] args) {


        threadPoolExecutor.execute(() -> System.out.println("呵呵呵"));



    }
}
