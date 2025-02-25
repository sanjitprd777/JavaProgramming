package low_level_design.leaderboard;

public class DLLNode {

    int count;
    String name;
    String country;
    DLLNode prev;
    DLLNode next;

    public DLLNode(String name, String country) {
        this.count = 1;
        this.name = name;
        this.country = country;
        this.prev = null;
        this.next = null;
    }

    public void incCount() {
        this.count++;
    }
}
