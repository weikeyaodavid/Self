/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package leetcode.B_String_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author weikeyao
 * @version task5_02.java, v 0.1 2023年12月19日 00:20 weikeyao
 */
public class task5_02 {

    //76. Minimum Window Substring
    //窗口扩展时寻找可行解，窗口收缩时优化可行解。而且这个题可行解每次都是一个
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> actual = new HashMap<>();
        int count = 0;
        String ans = s + t;
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            need.put(a, need.getOrDefault(a, 0) + 1);
        }

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (need.get(s.charAt(end)) != null) {
                actual.put(s.charAt(end), actual.getOrDefault(s.charAt(end), 0) + 1);
                if (actual.get(s.charAt(end)) <= need.get(s.charAt(end))) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (ans.length() > (end - start + 1)) {
                    ans = s.substring(start, end + 1);
                }
                if (need.get(s.charAt(start)) != null) {
                    actual.put(s.charAt(start), actual.get(s.charAt(start)) - 1);
                    if (actual.get(s.charAt(start)) < need.get(s.charAt(start))) {
                        count--;
                    }
                }
                start++;
            }
        }
        return ans.equals(s + t) ? "" : ans;
    }

    //1658. Minimum Operations to Reduce X to Zero
    public int minOperations(int[] nums, int x) {

        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1; // 全部移除也无法满足要求
        }
        int ans = -1;
        int left = 0;
        int sum = 0;
        int n = nums.length;
        for (int right = 0; right < n; ++right) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left++]; // 缩小子数组长度
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : n - ans;
    }
}