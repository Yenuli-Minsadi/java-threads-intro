package lk.threads;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i<10; i++) {
                System.out.println("Thread1 is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i<10; i++) {
                System.out.println("Thread2 is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(t1.isAlive());
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t2.isAlive());
        System.out.println("byeeeee");
//      join(); isAlive(); method nathuwa kroth mulin main eke byeeee sout ek run wenne
//      main() eke sout ek anthimt run krnnai join(); method eken current thread ek (main thread) pause krl calling thread ek (t1 and t2) run krl iwr krnne

    }
}