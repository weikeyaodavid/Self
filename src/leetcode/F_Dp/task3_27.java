/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package leetcode.F_Dp;

import leetcode.D_Tree.TreeNode;

/**
 *
 * @author weikeyao
 * @version task3_27.java, v 0.1 2024年01月15日 22:02 weikeyao
 */
public class task3_27 {

    // 198. House Robber
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length];
    }

    // 213. House Robber II
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }

    // 337. House Robber III
    public int rob3(TreeNode root) {
        if (root == null)
            return 0;
        int rootMax = root.getVal();
        if (root.getLeft() != null) {
            rootMax = rootMax + rob3(root.getLeft().getLeft()) + rob3(root.getLeft().getRight());
        }
        if (root.getRight() != null) {
            rootMax = rootMax + rob3(root.getRight().getLeft()) + rob3(root.getRight().getRight());
        }
        return Math.max(rootMax, rob3(root.getLeft()) + rob3(root.getRight()));
    }

    // 状态机DP https://www.bilibili.com/video/BV1ho4y1W7QK/?spm_id_from=333.788.recommend_more_video.0&vd_source=30813cdd3968362721bd4b3ad6e4ba94
    // 121. Best Time to Buy and Sell Stock
    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    // 122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    // 123. Best Time to Buy and Sell Stock III
    public int maxProfit3(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

    // 188. Best Time to Buy and Sell Stock IV
    public int maxProfit4(int k, int[] prices) {
        int[][] dp = new int[prices.length][k * 2 + 1];
        for (int i = 1; i < k * 2; i = i + 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
        }
        return dp[prices.length - 1][k * 2];
    }

    // 309. Best Time to Buy and Sell Stock with Cool
    public int maxProfit5(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 买入状态，要么维持买入状态，要么从冷冻期状态变为买入状态；
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 卖出状态，从买入状态转换为卖出状态；
            dp[i][1] = dp[i][0] + prices[i];
            // 冷冻期状态，要么维持冷冻期状态，要么从卖出状态转换为冷冻期状态。
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    // 714. Best Time to Buy and Sell Stock with Transaction Fee
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}