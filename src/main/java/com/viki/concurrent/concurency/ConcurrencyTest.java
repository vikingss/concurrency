package com.viki.concurrent.concurency;

import com.viki.concurrent.concurency.annoations.NotThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: xunruibo
 * @Description:
 * @Date: Created in 17:16 2018/4/23
 * @Modified By:
 */
@NotThreadSafe
public class ConcurrencyTest {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; ++i) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

    }

    private static void add() {
        count++;
    }


}
