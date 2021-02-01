package leetcode;

import java.util.*;

public class task1_28 {
    //80
    public static int[] removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast : nums) {
            if (slow < 2 || nums[slow - 2] != fast) {
                nums[slow] = fast;
                slow++;
            }
        }
        return nums;
    }

    //81
    public static boolean search(int[] nums, int target) {
        int first = 0;
        int end = nums.length - 1;
        int mid;
        while (first <= end) {
            mid = (first + end) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] > nums[first]) {
                if (nums[first] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else if (nums[mid] < nums[first]) {
                if (nums[mid] < target && target <= nums[end]) {
                    first = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                first = first + 1;
            }
        }
        return false;
    }

    //1
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1 || nums == null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey((target - nums[i]))) {
                return new int[]{map.get((target - nums[i])), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}

//    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Notice that the solution set must not contain duplicate triplets.

//
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//
//        Input: nums = []
//        Output: []
//
//        Input: nums = [0]
//        Output: []



