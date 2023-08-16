package com.yy.st;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列实现
 * @author yuyou
 * @since 2023/8/14 14:48
 */
public class BlockTest {

    public static void main(String[] args) throws InterruptedException {
        BlockQueue blockQueue = new BlockQueue(5);
        for (int i = 0; i < 5; i++) {
            blockQueue.put(i);
        }
        System.out.println(blockQueue);
        for (int i = 0; i < 5; i++) {
            System.out.println(blockQueue.take());
        }
        System.out.println(blockQueue);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(()  -> {
                try {
                    System.out.println("开始从队列中取出元素");
                    int  result = blockQueue.take();
                    System.out.println("从队列中取出元素为" + result);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
        Thread.sleep(1000);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println("开始往队列中放入元素");
                    int index = random.nextInt(1000);
                    blockQueue.put(index);
                    System.out.println("往队列中放入元素 " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }).start();
            Thread.sleep(1000);

        }
    }


    @Data
    public static class BlockQueue {
        int[] items;
        int count = 0;
        int takeIndex;
        int putIndex;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition notFull = reentrantLock.newCondition();
        Condition notEmpty = reentrantLock.newCondition();

        public BlockQueue(int capacity) {
            items = new int[capacity];
        }
        public void put(int item) throws InterruptedException {
            reentrantLock.lock();
            try {
                int[] items = this.items;
                while (count == items.length) {
                    notFull.await();
                }
                items[putIndex] = item;
                if (++putIndex == items.length) {
                    putIndex = 0;
                }
                count++;
                notEmpty.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                reentrantLock.unlock();
            }
        }

        public int take() throws InterruptedException {
            reentrantLock.lock();
            try {
                int[] items = this.items;
                while (count == 0) {
                    notEmpty.await();
                }
                int re = items[takeIndex];
                items[takeIndex] = 0;
                if (++takeIndex == items.length) {
                    takeIndex = 0;
                }
                count--;
                notFull.signal();
                return re;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                reentrantLock.unlock();
            }
        }

    }
}
