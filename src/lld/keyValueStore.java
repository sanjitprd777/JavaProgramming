package lld;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class keyValueStore {

	static class KeyValueStore<K, V> {
		private final ConcurrentHashMap<K, V> store;
		private final ReentrantLock lock;

		public KeyValueStore() {
			this.store = new ConcurrentHashMap<>();
			this.lock = new ReentrantLock();
		}

		// Get value by key
		public V getByKey(K key) {
			return store.get(key);
		}

		// Insert a new key-value pair
		public boolean insertKey(K key, V value) {
			return store.putIfAbsent(key, value) == null; // Only insert if key doesn't exist
		}

		// Update value safely with a lock
		public boolean updateValueByKey(K key, V newValue) {
			lock.lock(); // Acquire lock for thread safety
			try {
				if (store.containsKey(key)) {
					store.put(key, newValue);
					return true;
				}
				return false; // Key doesn't exist
			} finally {
				lock.unlock(); // Release lock
			}
		}

		// Remove a key
		public boolean removeKey(K key) {
			return store.remove(key) != null;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		KeyValueStore<String, Integer> store = new KeyValueStore<>();
		store.insertKey("counter", 0);

		Runnable updateTask = () -> {
			for (int i = 0; i < 1000; i++) {
				int currentValue = store.getByKey("counter");
				store.updateValueByKey("counter", currentValue + 1);
			}
		};

		// Create two threads updating the same key
		Thread thread1 = new Thread(updateTask);
		Thread thread2 = new Thread(updateTask);

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println("Final Counter Value: " + store.getByKey("counter"));
	}

}
