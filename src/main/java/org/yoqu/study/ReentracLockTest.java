package org.yoqu.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yoqu
 * @date 2018/4/21 - 08:57
 */
public class ReentracLockTest implements Runnable {

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private String result;

    public ReentracLockTest(String result) {
        this.result = result;
    }

    public static void main(String[] args) {
        ReentracLockTest t = new ReentracLockTest("hello");
        new Thread(t).start();
        try {
            t.lock.lock();
            t.condition.await();
            System.out.println(t.result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            t.lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            Thread.sleep(2000);
            result += Thread.currentThread().getId();
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }
}
