package demo1;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    static ReentrantLock reentrantLockA = new ReentrantLock();
    static ReentrantLock reentrantLockB = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            reentrantLockA.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "获取reentrantLockA成功，开始尝试获取reentrantLockB");
            try {
                reentrantLockB.tryLock(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            }finally {
                System.out.println("释放A锁");
                reentrantLockA.unlock();
            }
            System.out.println(Thread.currentThread() + "获取reentrantLockB成功");
            reentrantLockB.unlock();
            reentrantLockA.unlock();
        }, "线程A");

        Thread threadB = new Thread(() -> {
            reentrantLockB.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "获取reentrantLockB成功，开始尝试获取reentrantLockA");
            reentrantLockA.lock();
            System.out.println(Thread.currentThread() + "获取reentrantLockA成功");
            reentrantLockA.unlock();
            reentrantLockB.unlock();
        }, "线程B");
        threadA.start();
        threadB.start();

        Thread.sleep(3000);
        System.out.println(threadA.getState());
        System.out.println(threadB.getState());

    }
}
