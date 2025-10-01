package lk.threads;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        A a = new A();
        Thread threadA = new Thread(a);
        threadA.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        B b = new B();
        Thread threadB = new Thread(a);
        threadB.start();
    }
}

class A implements Runnable {

    @Override
    public void run(){
        for (int i = 0; i<10; i++) {
            System.out.println("A is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class B implements Runnable {

    @Override
    public void run(){
        for (int i = 0; i<10; i++) {
            System.out.println("A is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}