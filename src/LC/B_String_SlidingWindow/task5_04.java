/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package LC.B_String_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author weikeyao
 * @version task5_04.java, v 0.1 2023年12月22日 16:40 weikeyao
 */
public class task5_04 {

    //子数组问题个数推论
    //l满足要求  r满足要求
    //[l,r],[l+1,r] ... [r,r]
    //总共有 r-l+1个子数组符合要求

    //713. Subarray Product Less Than K
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int product = 1;
        int res = 0;
        while(right < nums.length){
            product = product * nums[right];
            while(left <= right && product >= k){
                product = product / nums[left];
                left++;
            }
            res = res + right - left + 1;
            right++;
        }
        return res;
    }

    //795. Number of Subarrays with Bounded Maximum
    //很巧妙，只看符合条件的和不符合条件之前的个数
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int indexLeft = 0;
        int indexRight = 0;
        int keyOne = -1;
        int keyTwo = 0;
        int res = 0;
        while(indexRight < nums.length){
            if(nums[indexRight] >= left && nums[indexRight] <= right){
                keyOne = indexRight;
            }
            if(nums[indexRight] > right){
                keyOne = -1;
                keyTwo = indexRight + 1;
            }
            if(keyOne != -1){
                res = res + keyOne - keyTwo + 1;
            }
            indexRight++;
        }
        return res;
    }

    //904. Fruit Into Baskets
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    //11
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while(start < end){
            if(height[start] <= height[end]){
                int acc = (end - start) * Math.min(height[end], height[start]);
                if(res < acc){
                    res = acc;
                }
                start++;
            } else {
                int acc = (end - start) * Math.min(height[end], height[start]);
                if(res < acc){
                    res = acc;
                }
                end--;
            }
        }
        return res;
    }
    //    直觉告诉我们，应该移动对应数字较小的那个指针（即此时的左指针）。这是因为，由于容纳的水量是由
    //    两个指针指向的数字中较小值指针之间的距离
    //    两个指针指向的数字中较小值指针之间的距离
    //    决定的。如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，
    //    后者「指针之间的距离」会减小，那么这个乘积会减小。因此，我们移动数字较大的那个指针是不合理的。因此，我们移动 数字较小的那个指针。
}