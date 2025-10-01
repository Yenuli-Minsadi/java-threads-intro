package lk.threads;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counts counts = new Counts();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i<1000; i++) {
                    counts.incrementValue();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i<1000; i++) {
                counts.incrementValue();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counts.getCount());
    }


}

class Counts {
    private int count = 0;
    public synchronized void incrementValue() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
// race condition - unpredictable results
// data inconsistency
// deadlock - infinite loop