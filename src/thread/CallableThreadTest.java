package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest {
    public static void test() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 1; i <= 100; i++) {
                    sum += i;
                }
                System.out.println(Thread.currentThread().getName() + ": " + sum);
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        Integer result = null;
        try {
            result = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " + result);
    }
}
