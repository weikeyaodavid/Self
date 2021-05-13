package leetcode.D_Dp;

import java.util.Arrays;

public class task3_29 {

    //关键解法 不好想
    //dp[i] = Math.max(dp[i - 1] + dp[i], dp[i]);
    //53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    //300. Longest Increasing Subsequence
    //状态转移方程好难想
    //dp[i] = Math.max(dp[i], dp[j] + 1);
    //dp[i] 表示：以 nums[i] 结尾 的「上升子序列」的长度
    //如果一个较大的数接在较小的数后面，就会形成一个更长的子序列。只要 nums[i] 严格大于在它位置之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    //673. Number of Longest Increasing Subsequence
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] res = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(res, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        res[i] = res[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        res[i] = res[j] + res[i];
                    }
                }
            }
        }
        int max = dp[0];
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) ans += res[i];
        }
        return ans;
    }


    //152. Maximum Product Subarray
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > 0){
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }

        }
        int res = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
