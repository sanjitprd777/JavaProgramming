package MultiThreading.BlockingQueueEx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerEx {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /*
        ** Enqueue methods
        // Put a new task into queue. Blocked until no space left for a new task to put.
        blockingQueue.put("abc");
        // Not block if there is no space, instead it throws IllegalStateException is no space left.
        blockingQueue.add("abc");
        // Not block, return true / false if an element is queued / not queueud.
        blockingQueue.offer("abc");
        // offer with timeout until space is not available. If space not available until 1 sec, an element not inserted, method returns false.
        // can throw interruptedException if interupped within timeouts.
        blockingQueue.offer("abc", 1000, TimeUnit.MILLISECONDS);
        // return first element without removing. Return null if queue is empty.
        blockingQueue.peek();
        // return first element without removing. Throw NoSuchElementException if queue is empty.
        blockingQueue.element();
        // Returns number of elements;
        blockingQueue.size();
        // Returns remaining size empty for taking more elements.
        blockingQueue.remainingCapacity();
        // Returns true/false if queue contains element.
        blockingQueue.contains("1");


        ** Dequeue metohds
        // Take existing task from queue. Blocked unit no new task present in queue. Throws interruptedException is interrupted during call to take.
        blockingQueue.take();
        // remove given element if present in queue.
        blockingQueue.remove("1");
        // Returns element. Returns null if no element is present in queue.
        blockingQueue.poll();
        // block until given time. If timeout returns null.
        blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        */

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
