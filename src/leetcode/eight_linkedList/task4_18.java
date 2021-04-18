package leetcode.eight_linkedList;

import worktest.ListNode;
import worktest.Node;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class task4_18 {

    //2. Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        int nextVal = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int val = (x + y + nextVal) % 10;
            nextVal = (x + y + nextVal) / 10;
            temp.next = new ListNode(val);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            temp = temp.next;
        }
        if (nextVal != 0) {
            temp.next = new ListNode(nextVal);
        }
        return res.next;
    }


    //138. Copy List with Random Pointer
    //深度复制问题可使用哈希表作为新旧元素一一对应
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            //p = p.next;
        }
        p = head;
        while (p != null) {
//            map.get(p).next = map.get(p.next);
//            map.get(p).random = map.get(p.random);
//            p = p.next;
        }
        return map.get(head);
    }



    //61. Rotate List
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode cur = head;
        // 统计链表长度：
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 对k化简：
        k %= len;
        if (k == 0) return head;
        // 快指针 fast 先走k步：
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        // 快慢指针再一起同步前进，直至fast走到尾节点停：
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时的慢指针slow的下一个节点就是旋转后的新头，原尾节点fast串连到老头head上：
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }



    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)return l1 == null ? l2 : l1;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = l1.val > l2.val ? l1 : l2;
        ListNode temp = dummyNode;
        while(l1 != null && l2 != null){
            temp.next = l1.val < l2.val ? l1 : l2;
            if(temp.next == l1)l1 = l1.next;
            else l2 = l2.next;
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }



    //148. Sort List
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        //找到中点
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        //递归切分
        ListNode left = sortList(head);
        ListNode right = sortList(tail);
        //合并
        ListNode start = new ListNode(-1);
        ListNode temp = start;
        while(left != null && right != null){
            if(left.val > right.val){
                temp.next = right;
                right = right.next;
            }else {
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }
        temp.next = left == null ? right : left;
        return start.next;
    }



    //86. Partition List
    //如果最后一个节点< x，p1.next就会指向最后一个节点而不是null
    public ListNode partition(ListNode head, int x) {
        ListNode large = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode p1 = large;
        ListNode p2 = small;
        while(head != null){
            if(head.val >= x){
                p1.next = head;
                p1 = p1.next;
            }else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = large.next;
        //如果最后一个节点< x，p1.next就会指向最后一个节点而不是null
        p1.next = null;
        return small.next;
    }



    //143. Reorder List
    public void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode rev = reverse(next);
        ListNode first = head;
        while(first != null && rev != null){
            ListNode temp = first.next;
            ListNode temp2 = rev.next;
            first.next = rev;
            rev.next = temp;
            first = temp;
            rev = temp2;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
