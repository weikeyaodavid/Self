/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package LC.B_String_SlidingWindow;

/**
 *
 * @author weikeyao
 * @version task_5_01.java, v 0.1 2023年12月17日 13:34 weikeyao
 */
public class task5_01 {

    //541. Reverse String II
    //字符串的处理，要先转为字符数组，处理后再转为字符串返回
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }
    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    //26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int right = 1;
        int left = 0;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                nums[left + 1] = nums[right];
                left++;
                right++;
            }
        }
        return left + 1;
    }

    //643. Maximum Average Subarray I
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        // 由于题目限制了 k <= len，因此不用做特判
        int windowSum = 0;
        // 第 1 步：先求出第 1 个窗口的和
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // 第 2 步：通过遍历求出除了第 1 个窗口的和
        int res = windowSum;
        // 循环不变量定义：[left..right) 是长度为 k 的窗口
        for (int right = k; right < len; right++) {
            // 加上一个数再减去一个数
            windowSum = windowSum + nums[right] - nums[right - k];
            res = Math.max(res, windowSum);
        }
        return (double) res / k;
    }

    //1052. Grumpy Bookstore Owner
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
        }

        int windowSum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                windowSum += customers[i];
            }
        }

        int largestSum = windowSum;

        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                windowSum = windowSum + customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                windowSum = windowSum - customers[i - minutes];
            }
            largestSum = Math.max(largestSum, windowSum);
        }
        return ans + largestSum;
    }
}