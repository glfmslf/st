package com.yy.st;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 通知等待机制
 * @author yuyou
 * @since 2023/8/11 16:36
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition notEmpty = reentrantLock.newCondition();
        Condition notFull = reentrantLock.newCondition();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                readLock.lock();
                System.out.println("读锁并发情况");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                readLock.unlock();

            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                writeLock.lock();
                System.out.println("写锁并发情况");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                writeLock.unlock();

            }).start();
        }

    }
}
