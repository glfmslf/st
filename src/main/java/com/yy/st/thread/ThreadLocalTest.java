package com.yy.st.thread;


/**
 * @author yuyou
 * @since 2023/3/25 15:18
 */
public class ThreadLocalTest {
    public static ThreadLocal<String> t1 = new ThreadLocal<>();
    public static ThreadLocal<String> t2 = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1;
        Thread thread2;
        thread1 = new Thread(() -> {
            t1.set("t11");
            t2.set("t12");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2 = new Thread(() -> {
            t1.set("t21");
            t2.set("t22");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(thread1.getThreadGroup());
        thread1.wait();
        thread2.wait();

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(thread1);
        System.out.println(thread2);
    }
}
