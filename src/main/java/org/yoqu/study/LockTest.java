package org.yoqu.study;

/**
 * @author yoqu
 * @date 2018/4/21 - 08:57
 */
public class LockTest implements Runnable {

    public synchronized void get(){
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set(){
        System.out.println(Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        LockTest t = new LockTest();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
