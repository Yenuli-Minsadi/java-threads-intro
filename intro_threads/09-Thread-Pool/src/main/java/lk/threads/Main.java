package lk.threads;

import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i=0; i<10; i++) {
            Runnable runnable = new MyRunnable("Thread "+ i);
            executor.execute(runnable);
        }
        executor.shutdown();
    }
}

class MyRunnable implements Runnable {
    private String threadName;
    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void run() {
        System.out.println("thread started: "+threadName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread finished :"+threadName);
    }
}