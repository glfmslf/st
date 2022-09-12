package com.yy.st.thread;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuyou
 * @since 2022/9/11 16:30
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            StopWatch stopWatch = new StopWatch("test");
            stopWatch.start();

            CountTest countTest = new CountTest();
            CountDownLatch countDownLatch = new CountDownLatch(2);
            countDownLatch.countDown();
            for (int j = 0; j < 2; j++) {
                new Thread(() -> {
                    countTest.cal();
                    countDownLatch.countDown();

                }).start();
            }
            countDownLatch.await();
            System.out.println(countTest.getCount());
            stopWatch.stop();
            System.out.println(stopWatch.getTotalTimeMillis());
            countTest.clear();
            System.out.println(Thread.currentThread() + "======================");
        }
    }

      public static class MainTest{

          public static void main(String[] args) throws InterruptedException {
              VolatileTest volatileTest = new VolatileTest();
              Thread thread = new Thread(volatileTest::write);
              Thread thread1 = new Thread(volatileTest::read);
              thread.start();
              thread1.start();
              thread.join();
              thread1.join();
          }
    }
}
