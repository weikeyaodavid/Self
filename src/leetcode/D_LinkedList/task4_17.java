package leetcode.D_LinkedList;

import worktest.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class task4_17 {

    //203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        while(cur != null){
            if(cur.val == val){
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return  dummyNode.next;
    }



    //234. Palindrome Linked List
    //更好的方法是反转链表来做
    public boolean isPalindrome2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            stack.add(cur.val);
            cur = cur.next;
        }
        ListNode temp= head;
        for(int i = 0; i < stack.size(); i++){
            if(stack.pop() != temp.val)return false;
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> store = new LinkedList<>();
        int count = 0;
        while(head != null){
            store.push(head);
            head = head.next;
            count++;
        }

        for(int i = 0; i < count / 2; i++){
            if(store.remove().val != store.removeLast().val){
                return false;
            }
        }
        return true;
    }

    //328. Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if(head == null)return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode start = even;
        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = start;
        return dummyNode.next;
    }
}
