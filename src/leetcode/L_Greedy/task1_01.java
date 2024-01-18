/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package leetcode.L_Greedy;

import java.util.Arrays;

/**
 *
 * @author weikeyao
 * @version task1_01.java, v 0.1 2024年01月15日 00:16 weikeyao
 */
public class task1_01 {

    // 455. Assign Cookies
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length, n = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && g[i] > s[j]) {
                j++;
            }
            if (j < n) {
                count++;
            }
        }
        return count;
    }

    // 55. Jump Game
    //从中间或末尾状态想
    public boolean canJump(int[] nums) {
        int cover = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > cover)return false;
            cover = Math.max(cover, i + nums[i]);
        }
        return true;
    }

    //45. Jump Game II
    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(nums[i] + i, maxPos);
            if (i == end) {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }

    // 135. Candy
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}