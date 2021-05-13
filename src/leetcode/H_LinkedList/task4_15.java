package leetcode.H_LinkedList;

import worktest.ListNode;

public class task4_15 {

    //141. Linked List Cycle
    //注意空指针异常， 返回null时的条件
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null)return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }



    //142. Linked List Cycle II
    //相遇时 slow 走过的路程 x + y   fast 走过的路程 x + y + z + y
    //又因为 fast 走过的路程是slow的两倍 x + y + z + y = 2(x + y)  ->  x = z
    //意味着 head 到环起始点的距离 等于 相遇点到环起始点的距离
    //所以慢环继续走，快环从head点开始每次走一个，再次相遇就是环开始的地方
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast){
            if(fast == null || fast.next == null)return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }



    //160. Intersection of Two Linked Lists
    //链表有很多逻辑题，画图找规律更直观
    //每个旅程都走过各自不相同的节点，在节点相同时相遇
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)return null;
        ListNode A = headA;
        ListNode B = headB;
        while(A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return B;
    }



    //19. Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}
