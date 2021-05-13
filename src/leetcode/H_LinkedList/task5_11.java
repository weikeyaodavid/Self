package leetcode.H_LinkedList;

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



    //146. LRU Cache
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
        //rand49
        while(true){
            int num = (rand7() - 1) * 7 + rand7();
            if(num <= 40)return num % 10 + 1;
        }
    }
    public int rand7(){
        return 0;
    }
}