package MultiThreading.ExchangerEx;

import java.util.concurrent.Exchanger;

public class ExchangerClass {

    /*
    To exchange data between threads, we can use Exchanger service.
    When exchanger calls the exchange method, it waits for another thread to come to this point, then it exchanges the
    data and proceeds with execution of both threads.
     */
    public static void main(String[] args) {
        int t = 2;
        Exchanger<Integer> exchanger = new Exchanger<>();

        Thread[] th = new Thread[t];
        for (int i = 0; i < t; ++i) {
            th[i] = new CustomThread(exchanger);
            th[i].start();
        }

        for (int i = 0; i < t; ++i) {
            try {
                th[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
}
