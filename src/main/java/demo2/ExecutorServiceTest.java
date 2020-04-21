package demo2;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
    public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16,
            120, TimeUnit.SECONDS, new LinkedBlockingQueue<>(120));



    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**写法1**/
       List<ImageTask> list = Lists.newArrayList();
        list.add(new ImageTask());
        list.add(new ImageTask());
        list.add(new ImageTask());
        list.add(new ImageTask());
/*
        Long t = System.currentTimeMillis();
        CompletionService<String> completionService = new ExecutorCompletionService<String>(threadPoolExecutor);
        for(int i = 0;i<4;i++){
            int finalI = i;
            completionService.submit(() -> list.get(finalI).producerImage(finalI));
        }

        for(int i=0;i<4;i++){
            Future<String> take = completionService.take();
            System.out.println(take.get());
        }
        System.out.println("执行结束耗费:" + (System.currentTimeMillis() - t)+"ms");
        threadPoolExecutor.shutdownNow();
*/




       /***慢版本*/
/*        Long t = System.currentTimeMillis();
        Future<List<String>> submit = threadPoolExecutor.submit((Callable<List<String>>) () -> {
            List<String> strings = Lists.newArrayList();
            for (int i = 0; i < 4; i++) {
                strings.add(list.get(i).producerImage(i));
            }
            return strings;
        });
        List<String> list1 = submit.get();
        for(String s : list1){
            System.out.println(s);
        }
        System.out.println("执行结束耗费:" + (System.currentTimeMillis() - t)+"ms");
        threadPoolExecutor.shutdownNow();*/


         /***方法3，还是没方法1优秀**/
        Long t = System.currentTimeMillis();
        List<Future> list1 = Lists.newArrayList();
        for(int i= 0;i< 4 ;i++){
            int finalI = i;
            Future<String> submit = threadPoolExecutor.submit(() -> {
                List<String> strings = Lists.newArrayList();
                    return list.get(finalI).producerImage(finalI);
            });
            list1.add(submit);
        }

        for(Future  future: list1){
            System.out.println(future.get());
        }
        System.out.println("执行结束耗费:" + (System.currentTimeMillis() - t)+"ms");
        threadPoolExecutor.shutdownNow();
    }
}
