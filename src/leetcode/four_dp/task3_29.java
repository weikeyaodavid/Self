package leetcode.four_dp;

public class task3_29 {

    //关键解法 不好想
    //dp[i] = Math.max(dp[i - 1] + dp[i], dp[i]);
    //53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = dp[0];
        for(int i = 1; i < dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    //300. Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        

        return 0;
    }


}
