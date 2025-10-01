package lk.threads;

public class ImplementRunnableInterface{

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("run...");
    }
}
