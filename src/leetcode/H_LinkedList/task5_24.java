package leetcode.H_LinkedList;

import worktest.ListNode;

public class task5_24 {
    //83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(pre.val == cur.val){
                cur = cur.next;
                pre.next = cur;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
