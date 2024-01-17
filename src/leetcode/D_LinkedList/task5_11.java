package leetcode.D_LinkedList;

import worktest.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class task5_11 {

    //25. Reverse Nodes in k-Group
    //0 1 2 3 4
    //s   e
    //  pr po
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        while(true){
            for(int i = 0; i < k; i++){
                end = end.next;
                if(end == null) return dummy.next;
            }
            ListNode pre = start.next;
            ListNode pos = end.next;
            end.next = null;
            start.next = reverse(start.next);
            pre.next = pos;
            start = pre;
            end = pre;
        }
    }
    public ListNode reverse(ListNode root){
        ListNode pre = null;
        ListNode cur = root;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        int count = 0;
        int level = 1;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0; i < count/k; i++){
            dummy.next = reverse2(dummy.next, 1 + i * k, i * k + k);
        }
        return dummy.next;
    }
    private ListNode reverse2(ListNode head, int left, int right){
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        int countLeft = 1;
        while(countLeft < left){
            countLeft++;
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode post = cur.next;
        for(int i = 0; i < right - left; i++){
            cur.next = post.next;
            post.next = pre.next;
            pre.next = post;
            post = cur.next;
        }
        return dummy.next;
    }



    //146. LRU Cache
    class LRUCache {

        int size;
        Map<Integer, Node> map;
        Node head;
        Node tail;

        public LRUCache(int capacity) {
            size = capacity;
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(map.get(key) == null){
                return -1;
            }
            Node node = map.get(key);
            removeNode(node);
            addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(map.get(key) != null){
                Node node = map.get(key);
                node.value = value;
                removeNode(node);
                addFirst(node);
            }else{
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addFirst(newNode);
                if(size < map.size()){
                    Node node = removeLastNode();
                    map.remove(node.key);
                }
            }
        }

        public void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addFirst(Node node){
            node.pre = head;
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
        }

        public Node removeLastNode(){
            Node node = tail.pre;
            removeNode(node);
            return node;
        }
    }

    class Node{

        int value;
        int key;
        Node pre;
        Node next;

        public Node(int mapKey, int val){
            value = val;
            key = mapKey;
        }
    }

    //----------------------------------------------------------------------
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */


    class LRUCacheBeta<K, V> {
        int capacity;
        Map<K, V> map;
        LinkedList<K> list;

        public LRUCacheBeta(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
        }

        /**
         * 添加元素
         * 1.元素存在，放到队尾
         * 2.不存在，判断链表是否满。
         * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
         * 如果不满，放入队尾元素，更新哈希表
         */
        public void put(K key, V value) {
            V v = map.get(key);
            if (v != null) {
                list.remove(key);
                list.addLast(key);
                map.put(key, value);
                return;
            }

            //队列未满，添加到尾部
            if (list.size() < capacity) {
                list.addLast(key);
                map.put(key, value);
            } else {
                //队列已满，移除队首
                K firstKey = list.removeFirst();
                map.remove(firstKey);
                list.addLast(key);
                map.put(key, value);
            }
        }

        /**
         * 访问元素
         * 元素存在，放到队尾
         */
        public V get(K key) {
            V v = map.get(key);
            if (v != null) {
                list.remove(key);
                list.addLast(key);
                return v;
            }
            return null;
        }
    }



    //470. Implement Rand10() Using Rand7()
    //(rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
    public int rand10() {
        int addFive;
        int base;
        do {
            addFive = rand7();
        } while (addFive < 6);

        do {
            base = rand7();
        } while (base > 5);

        return addFive % 2 == 1 ? base + 5 : base;
    }
    public int rand7(){
        return 0;
    }
}