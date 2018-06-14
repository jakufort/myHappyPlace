package main.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Latches {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i=0;i<2;i++) {
            service.submit(new MyTask(latch));
        }

        System.out.println("wait start");
        latch.await();
        System.out.println("after wait");
        service.shutdown();
    }

    private static class MyTask implements Callable<String> {

        private final CountDownLatch latch;

        public MyTask(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            System.out.println("counted down: " + Thread.currentThread().getName());
            latch.countDown();
            return Thread.currentThread().getName();
        }
    }
}
