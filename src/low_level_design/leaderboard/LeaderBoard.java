package low_level_design.leaderboard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class LeaderBoard {

    DoublyLinkedList dll;
    HashMap<String, DLLNode> keyNodeMap;
    TreeMap<Integer, HashSet<DLLNode>> freqNodeMap;

    public LeaderBoard() {
        dll = new DoublyLinkedList();
        keyNodeMap = new HashMap<>();
        freqNodeMap = new TreeMap<>();
        freqNodeMap.computeIfAbsent(Integer.MAX_VALUE, (v -> new HashSet<>())).add(dll.head);
    }

    // Get leaderboard - Top K
    public void get(int k) {
        DLLNode head = dll.head.next;
        while (head!=dll.tail && k>0) {
            int cnt = head.count;
            while (cnt>0 && k>0) {
                System.out.println(head.name + " : " + head.country);
                cnt--;
                k--;
            }
            head = head.next;
        }

        System.out.println("==================================");
    }

    // Add element - Sanjit India
    public void add(String name, String country) {
        String key = name + "#" + country;
        if (keyNodeMap.containsKey(key)) {
            DLLNode node = keyNodeMap.get(key);
            dll.detachNode(node);
            freqNodeMap.get(node.count).remove(node);
            if (freqNodeMap.get(node.count).isEmpty())
                freqNodeMap.remove(node.count);
            dll.addAfterNode(freqNodeMap.get(freqNodeMap.higherKey(node.count)).iterator().next(), node);
            node.incCount();
            freqNodeMap.computeIfAbsent(node.count, (v -> new HashSet<>())).add(node);
        } else {
            DLLNode node = new DLLNode(name, country);
            dll.addLast(node);
            keyNodeMap.put(key, node);
            freqNodeMap.computeIfAbsent(node.count, (v -> new HashSet<>())).add(node);
        }
    }
}
