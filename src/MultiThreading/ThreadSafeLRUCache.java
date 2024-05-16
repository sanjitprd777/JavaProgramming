import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeLRUCache<K, V> {

    private final int capacity;
    private final ConcurrentHashMap<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public ThreadSafeLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>(capacity);
        this.list = new DoublyLinkedList<>();
    }

    public V get(K key) {
        lock.readLock().lock();
        try {
            Node<K, V> node = map.get(key);
            if (node == null) {
                return null;
            }
            list.moveToHead(node);
            return node.value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public V put(K key, V value) {
        lock.writeLock().lock();
        try {
            Node<K, V> existingNode = map.get(key);
            if (existingNode != null) {
                existingNode.value = value;
                list.moveToHead(existingNode);
                return value;
            }

            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            list.addHead(newNode);

            if (map.size() > capacity) {
                Node<K, V> removed = list.removeTail();
                assert removed != null;
                map.remove(removed.key);
            }
            return null;
        } finally {
            lock.writeLock().unlock();
        }
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList<K, V> {

        private Node<K, V> head;
        private Node<K, V> tail;

        public void addHead(Node<K, V> node) {
            node.prev = null;
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
        }

        public void moveToHead(Node<K, V> node) {
            if (node == head) {
                return;
            }
            removeNode(node);
            addHead(node);
        }

        public Node<K, V> removeTail() {
            if (tail == null) {
                return null;
            }
            Node<K, V> removed = tail;
            if (head == tail) {
                head = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            return removed;
        }

        private void removeNode(Node<K, V> node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
        }
    }
}
