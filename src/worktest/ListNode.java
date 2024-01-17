package worktest;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode nextNode) {
        val = x;
        next = nextNode;
    }

}
