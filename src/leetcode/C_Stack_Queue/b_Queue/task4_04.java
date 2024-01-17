/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package leetcode.C_Stack_Queue.b_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author weikeyao
 * @version task4_04.java, v 0.1 2024年01月11日 20:25 weikeyao
 */
public class task4_04 {
    // 225. 用队列实现栈


    // 622. 设计循环队列


    // 239. 滑动窗口最大值   单调队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}