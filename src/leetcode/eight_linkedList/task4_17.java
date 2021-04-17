package leetcode.eight_linkedList;

import worktest.ListNode;

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
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverseLast = reverse(slow);
        ListNode temp2 = reverseLast;
        while(temp2 != null){
            if(temp.val != temp2.val)return false;
            temp = temp.next;
            temp2 = temp2.next;
        }
        slow.next = reverse(reverseLast);
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
