package leetcode.H_LinkedList;

import worktest.ListNode;

public class task4_16 {

    //206. Reverse Linked List
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }



    //92. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode tail = cur.next;
        for(int i = 0; i < right- left; i++){
            cur.next = tail.next;
            tail.next = pre.next;
            pre.next = tail;
            tail = cur.next;
        }
        return dummyNode.next;
    }
}
