package leetcode;

import java.util.Arrays;

public class task2_01 {
    //16
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    //11
    public int maxArea(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length - 1; i++){

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
//Given an array nums of n integers and an integer target, find three integers in nums
// such that the sum is closest to target. Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
