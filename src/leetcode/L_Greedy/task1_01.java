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
        int cover = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > cover)return 0;
            if(i + nums[i] > cover)count++;
            cover = Math.max(cover, i + nums[i]);
        }
        return count;
    }

    // 135. Candy
    public int candy(int[] ratings) {

    }

}