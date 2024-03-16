package LC.D_LinkedList;

import worktest.ListNode;

import java.util.LinkedList;

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
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }
    public ListNode reverseList3(ListNode head) {
        LinkedList<ListNode> store = new LinkedList<>();
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode temp = start;

        while(head != null){
            store.push(head);
            head = head.next;
        }

        while(!store.isEmpty()){
            temp.next = store.pop();
            temp = temp.next;
        }
        temp.next = null;
        return start.next;
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
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        LinkedList<ListNode> store = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        int count = 1;

        while(count < left){
            count++;
            temp = temp.next;
        }

        ListNode start = temp;

        for(int i = 0; i < right - left + 1; i++){
            temp = temp.next;
            store.push(temp);
        }

        ListNode end = temp.next;

        while(!store.isEmpty()){
            start.next = store.pop();
            start = start.next;
        }

        start.next = end;
        return dummy.next;
    }
}
