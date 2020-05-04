package demo1;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


@Slf4j
public class ReentrantLocktTest {
    /**
     * 可重入锁，默认非公平锁,传true表示公平锁
     */
    static  ReentrantLock reentrantLock = new ReentrantLock(false);
    public static void main(String[] args) throws InterruptedException {
        /**测试公平锁和非公平锁**/
        test01();
     /*   for(;;){
            new Thread(() -> {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName()+"插队线程获取锁");
                System.out.println(Thread.currentThread().getName()+"插队线程释放锁");
                reentrantLock.unlock();
            }).start();
        }*/
    }

    static void test01(){
        List<Thread> list = Lists.newArrayList();
        for(int i=0;i<10;i++){
            list.add(new Thread(() -> {
                reentrantLock.lock();
              log.info(Thread.currentThread().getName()+"获取锁");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(Thread.currentThread().getName()+"释放锁");
                reentrantLock.unlock();
            },"线程"+i));
        }
        for(int i=0;i<10;i++){
            list.get(i).start();
        }
    }
}
