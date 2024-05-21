package MultiThreading.MyBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue {

    private int limit;
    private Queue queue;

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        queue = new LinkedList();
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit)
            wait();
        this.queue.add(item);
        if (this.queue.size()==1)
            notifyAll();
    }

    public synchronized Object dequeue(Object item) throws InterruptedException {
        while (this.queue.size()==0)
            wait();
        if (this.queue.size()==this.limit)
            notifyAll();
        return this.queue.remove();
    }
}
