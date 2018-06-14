package main.concurrent;

import java.util.concurrent.*;

public class MyExecutors {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<String> result = service.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("task thread");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "test";
        });

        System.out.println("main thread");
        System.out.println(Thread.currentThread().getName());
        try {
            String ans = result.get(2, TimeUnit.SECONDS);
            System.out.println("ans: " + ans);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        service.shutdown();

    }
}
