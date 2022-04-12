package com.example.demo.currentlimiting;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreTest {

    private static final int THREAD_ACCOUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_ACCOUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String args[]) {
        for(int i = 0; i < THREAD_ACCOUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println("这是一个请求接口~");
                        Thread.sleep(5000);
                        semaphore.release();
                    }catch (InterruptedException exception) {
                        log.error("InterruptedException", exception);
                    }
                }
            });
        }
        threadPool.shutdown();
    }

}
