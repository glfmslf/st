package com.yy.st.thread.futuretask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuyou
 * @since 2023/1/2 14:24
 */
public class MyFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> ft2 = new FutureTask<>(() -> {
//            System.out.println("T2:洗茶壶 ");
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("T2:洗茶杯");
//            TimeUnit.SECONDS.sleep(2);
//            System.out.println("T2:拿茶叶");
//            TimeUnit.SECONDS.sleep(1);
//            return "龙井";
//        });
//
//        FutureTask<String> ft1 = new FutureTask<>(() -> {
//            System.out.println("T1:洗水壶");
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("T1:烧开水");
//            TimeUnit.SECONDS.sleep(15);
//            //获取T2线程的茶叶
//            String tf = ft2.get();
//            System.out.println("T1:拿到茶叶: " + tf);
//            System.out.println("T1:泡茶");
//            return "上茶: " + tf;
//        });
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadFactory() {
//            private AtomicInteger index = new AtomicInteger();
//
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r, "my_future_task" + index.getAndIncrement());
//            }
//        }, new ThreadPoolExecutor.CallerRunsPolicy());
//
//        threadPoolExecutor.submit(ft1);
//        threadPoolExecutor.execute(ft2);
//        System.out.println(ft1.get());

        //任务1：洗水壶->烧开水
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(()->{
                    System.out.println("T1:洗水壶...");
                    sleep(1, TimeUnit.SECONDS);
                    System.out.println("T1:烧开水...");
                    sleep(15, TimeUnit.SECONDS);
                });
        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(()->{
                    System.out.println("T2:洗茶壶...");
                    sleep(1, TimeUnit.SECONDS);
                    System.out.println("T2:洗茶杯...");
                    sleep(2, TimeUnit.SECONDS);
                    System.out.println("T2:拿茶叶...");
                    sleep(1, TimeUnit.SECONDS);
                    return "龙井";
                });
        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 =
                f1.thenCombine(f2, (__, tf)->{
                    System.out.println("T1:拿到茶叶:" + tf);
                    System.out.println("T1:泡茶...");
                    return "上茶:" + tf;
                });
        //等待任务3执行结果
        System.out.println(f3.join());
    }


    public static void sleep(int t, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
