package multithreading.ExchangerEx;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class CustomThread extends Thread {

    Exchanger<Integer> exchanger;

    public CustomThread(Exchanger<Integer> e) {
        this.exchanger = e;
    }

    public void run() {
        Random r = new Random();
        int s = r.nextInt(10);
        System.out.println(Thread.currentThread().getName() + " : " + s);
        try {
            int t = exchanger.exchange(s);
            System.out.println(Thread.currentThread().getName() + " : " + t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
