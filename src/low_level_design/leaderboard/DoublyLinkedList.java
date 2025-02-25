package low_level_design.leaderboard;

public class DoublyLinkedList {

    DLLNode head;
    DLLNode tail;

    public DoublyLinkedList() {
        head = new DLLNode(null, null);
        tail = new DLLNode(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addLast(DLLNode node) {
        DLLNode tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }

    public void detachNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addAfterNode(DLLNode node, DLLNode nodeToAdd) {
        DLLNode nodeNext = node.next;
        node.next = nodeToAdd;
        nodeToAdd.prev = node;
        nodeToAdd.next = nodeNext;
        nodeNext.prev = nodeToAdd;
    }
}
