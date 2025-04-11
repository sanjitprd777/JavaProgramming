package lld;

import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Initializing head and tail with a dummy nodes
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    HashMap<Integer, Node> mp = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newnode) {
        // This add a new node at front of DLL.
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void deleteNode(Node delnode) {
        // Delete a given node from DLL.
        Node prev = delnode.prev;
        Node next = delnode.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            Node resNode = mp.get(key);
            int ans = resNode.val;

// Now moving the accessed node to top of DLL (Keeping least recently used at top)
            mp.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            mp.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        // first delete if key exist.
        if (mp.containsKey(key)) {
            Node curr = mp.get(key);
            mp.remove(key);
            deleteNode(curr);
        }

// Delete the last element from DLL which was not used for maximum time
        if (mp.size() == capacity) {
            mp.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value)); // add new node at top of DLL
        mp.put(key, head.next);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

/*
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
 */




