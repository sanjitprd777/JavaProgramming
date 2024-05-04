package MultiThreading.ExchangerEx;

import java.util.concurrent.Exchanger;

public class ExchangerClass {

    /*
    To exchange data between threads, we can use Exchanger service.
    When exchanger calls the exchange method, it waits for another thread to come to this point, then it exchanges the
    data and proceeds with execution of both threads.

    The Exchanger class in Java can be used to share objects between two threads of type T. The class provides only a
    single overloaded method exchange(T t).
    When invoked exchange waits for the other thread in the pair to call it as well. At this point, the second
    thread finds the first thread is waiting with its object. The thread exchanges the objects they are holding
    and signals the exchange, and now they can return.
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
