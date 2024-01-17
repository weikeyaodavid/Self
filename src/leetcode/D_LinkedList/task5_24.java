package leetcode.D_LinkedList;

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



    //82. Remove Duplicates from Sorted List II
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode guard=new ListNode();
        guard.next=head;
        ListNode pre=guard;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null && cur.next.val==cur.val) cur=cur.next;
            if(pre.next==cur)  pre=pre.next;
            else pre.next=cur.next;
            cur=cur.next;
        }
        return guard.next;
    }

    //876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
