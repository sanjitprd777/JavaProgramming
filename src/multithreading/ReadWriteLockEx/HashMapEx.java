package multithreading.ReadWriteLockEx;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HashMapEx {

    HashMap<Integer, Integer> hm;
    ReadWriteLock readWriteLock;

    public HashMapEx() {
        hm = new HashMap<>();
        readWriteLock = new ReentrantReadWriteLock();
    }

    public void put(int x, int y) {
        try {
            readWriteLock.writeLock().lock();
            hm.put(x, y);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int get(int x) {
        try {
            readWriteLock.readLock().lock();
            return hm.getOrDefault(x, 0);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
