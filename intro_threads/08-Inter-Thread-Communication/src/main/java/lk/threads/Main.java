package lk.threads;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        new Producer(count);
        new Consumer(count);
    }
}

class Producer implements Runnable {
    Count count;
    public Producer(Count count) {//inject class thru constructor
        this.count=count;
        Thread t1 = new Thread(this,"Producer");//name thread
        t1.start();
    }
    @Override
    public void run() {
        int i=0;

        while (true) {
            count.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
//put
}

class Consumer implements Runnable {
    Count count;
    public Consumer(Count count) {//inject class thru constructor
        this.count=count;
        Thread t2 = new Thread(this,"Consumer");//name thread
        t2.start();
    }
    @Override
    public void run() {
        while (true) {
            count.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
//get
}

class Count  {
    int num;
    boolean flag = false;
    public synchronized void put(int num) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("PUT: "+ num);
        this.num=num;
        flag=true;
        notify();
    }
    public synchronized void get(){

        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("GET: "+ num);
//        this.num=num;
        flag=false;
        notify();
    }
//    checking if the put t1 only gives out the num thru t2
}

