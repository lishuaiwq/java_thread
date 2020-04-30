package demo1;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocktTest {
    /**
     * 可重入锁，默认非公平锁,传true表示公平锁
     */
    static ReentrantLock reentrantLock = new ReentrantLock(true);
    public static void main(String[] args) {
        /**测试公平锁和非公平锁**/
        test01();
    }

    static void test01(){
        List<Thread> list = Lists.newArrayList();
        for(int i=0;i<10;i++){
            list.add(new Thread(() -> {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName()+"获取锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"释放锁");
                reentrantLock.unlock();
            }));
        }
        for(int i=0;i<10;i++){
            list.get(i).start();
        }
    }
}
