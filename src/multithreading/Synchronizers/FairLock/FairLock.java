package multithreading.Synchronizers.FairLock;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
    /*
    Every thread calling lock() is now queued, and only the first thread in the queue is allowed to lock the FairLock
    instance, if it is unlocked. All other threads are parked waiting until they reach the top of the queue.

    Working:

    First, you might notice that the lock() method is no longer declared synchronized. Instead, only the blocks necessary
    to synchronize are nested inside synchronized blocks.

    FairLock creates a new instance of QueueObject and enqueue it for each thread calling lock(). The thread calling
    unlock() will take the top QueueObject in the queue and call doNotify() on it, to awaken the thread waiting on that
    object. This way only one waiting thread is awakened at a time, rather than all waiting threads.
    This part is what governs the fairness of the FairLock.

    Notice how the state of the lock is still tested and set within the same synchronized block to avoid slipped conditions.

    Also notice that the QueueObject is really a semaphore. The doWait() and doNotify() methods store the signal internally
    in the QueueObject. This is done to avoid missed signals caused by a thread being preempted just before calling
    queueObject.doWait(), by another thread which calls unlock() and thereby queueObject.doNotify().
    The queueObject.doWait() call is placed outside the synchronized(this) block to avoid nested monitor lockout, so another
    thread can actually call unlock() when no thread is executed inside the synchronized(this) block in lock() method.

    Finally, notice how the queueObject.doWait() is called inside a try - catch block. In case an InterruptedException
    is thrown, the thread leaves the lock() method, and we need to dequeue it.


     */

    private boolean           isLocked       = false;
    private Thread            lockingThread  = null;
    private List<QueueObject> waitingThreads =
            new ArrayList<>();

    public void lock() throws InterruptedException{
        QueueObject queueObject           = new QueueObject();
        boolean     isLockedForThisThread = true;
        synchronized(this){
            waitingThreads.add(queueObject);
        }

        while(isLockedForThisThread){
            synchronized(this){
                isLockedForThisThread =
                        isLocked || waitingThreads.get(0) != queueObject;
                if(!isLockedForThisThread){
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try{
                queueObject.doWait();
            }catch(InterruptedException e){
                synchronized(this) { waitingThreads.remove(queueObject); }
                throw e;
            }
        }
    }

    public synchronized void unlock(){
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked      = false;
        lockingThread = null;
        if(waitingThreads.size() > 0){
            waitingThreads.get(0).doNotify();
        }
    }
}