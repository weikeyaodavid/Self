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

    //补充题1. 排序奇升偶降链表
    //1->4->3->2->5 给定一个链表奇数部分递增，偶数部分递减，要求在O(n)时间复杂度内将链表变成递增
    public ListNode sortList(ListNode head){
        // 首先拆分奇偶链表
        ListNode dumyOdd = new ListNode(-1);
        ListNode odd = dumyOdd;

        ListNode dumyEven = new ListNode(-1);
        ListNode even = dumyEven;

        ListNode now = head;
        while(now != null){
            if((now.val & 1) == 1){
                odd.next = now;
                odd = odd.next;
            }else{
                even.next = now;
                even = even.next;
            }
            now = now.next;
        }
        odd.next = null;// 将尾节点置为null
        even.next = null;// 将尾节点置为null

        // 接着翻转偶数链表
        even = reverseList(dumyEven.next);
        odd = dumyOdd.next;

        // 最后合并奇偶链表
        return mergeList(odd, even);
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode now = head;
        while(now != null){
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
        }
        return pre;
    }

    private ListNode mergeList(ListNode odd, ListNode even){
        ListNode dumyList = new ListNode(-1);
        ListNode now = dumyList;
        while(odd != null || even != null){
            if(odd == null){
                now.next = even;
                even = even.next;
            }else if(even == null){
                now.next = odd;
                odd = odd.next;
            }else{
                if(even.val <= odd.val){
                    now.next = even;
                    even = even.next;
                }else{
                    now.next = odd;
                    odd = odd.next;
                }
            }
            now = now.next;
        }
        return dumyList.next;
    }
}
