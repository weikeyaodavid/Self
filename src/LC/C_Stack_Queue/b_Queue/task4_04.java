/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package LC.C_Stack_Queue.b_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author weikeyao
 * @version task4_04.java, v 0.1 2024年01月11日 20:25 weikeyao
 */
public class task4_04 {

    // 225. 用队列实现栈
    LinkedList<Integer> que1;
    /** Initialize your data structure here. */
//    public MyStack() {
//        que1 = new LinkedList<>();
//    }

    /** Push element x onto stack. */
    public void push(int x) {
        que1.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = que1.size();
        size--;
        // 将 que1 导入 que2 ，但留下最后一个值
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }
        int res = que1.pollFirst();
        return res;
    }

    /** Get the top element. */
    public int top() {
        return que1.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty();
    }

    // 622. 设计循环队列


    // 239. 滑动窗口最大值
    // 单调队列 ：从「维护单调性」的角度上来说，单调队列和单调栈是一样的，一个弹出队尾元素，另一个弹出栈顶元素。在单调栈的基础上，
    // 单调队列多了一个「移除队首」的操作，这类似滑动窗口移动左指针 left 的过程。所以从某种程度上来说，单调队列 = 单调栈 + 滑动窗口。
    // https://www.bilibili.com/video/BV1bM411X72E/?spm_id_from=333.337.search-card.all.click&vd_source=30813cdd3968362721bd4b3ad6e4ba94
    //
    // 1. 当前元素大于队尾，弹出队尾元素
    // 2. 弹出队首不在窗口内元素
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            while(queue.size() > 0 && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            if(i - queue.peekFirst() == k){
                queue.removeFirst();
            }
            if(i >= k - 1)res.add(nums[queue.peekFirst()]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}