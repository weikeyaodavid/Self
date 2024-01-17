package leetcode.A_Array;

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
                if (Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
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
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}

