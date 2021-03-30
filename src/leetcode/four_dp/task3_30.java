package leetcode.four_dp;

public class task3_30 {

    //198. House Robber
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[0] = 0;
        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }


    //213. House Robber II
    public int rob2(int[] nums) {

        
    }
}
