package demon3;

import javassist.bytecode.analysis.Executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
    public static final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

public static  final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        /**多少秒后执行，计算的时间包含任务执行的时间**/
        executorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+sf.format(new Date())+"1");
        }, 1, 3, TimeUnit.SECONDS);

        /**多少秒后执行，计算的时间不包含任务执行的时间**/
        executorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+sf.format(new Date())+"2");
        }, 1, 3, TimeUnit.SECONDS);
        System.out.println("主线程指定");
    }
}
