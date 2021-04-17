package leetcode.eight_linkedList;

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
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode last = null;
        ListNode waitOne = null;
        ListNode waitTwo = null;
        ListNode temp = dummyNode;
        ListNode cur = head;
        for(int i = 1; i < right; i++){
            cur = cur.next;
            if(i < left) pre = pre.next;
            if(i == left){
                pre.next = null;
                waitOne = pre;
            }
        }
        waitTwo = cur.next;
        cur.next = null;
        ListNode ss = reverse(pre);
        last = temp;
        waitOne.next = pre;
        ss.next = waitTwo;
        return head;
    }
    public ListNode reverse(ListNode rev){
        ListNode pre = rev;
        ListNode cur = rev.next;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return rev;
    }
}
