/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package LC.F_Dp;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author weikeyao
 * @version task3_26.java, v 0.1 2024年01月14日 16:05 weikeyao
 */
public class task3_26 {
    // 完全背包问题

    // 现在有四种物品，每种物品有无限件，它们的重量与价值如下表。
    // 现在有一个背包，总容量为8。问怎么选取物品，可以使得背包装的物品价值最大？
    //    物品编号	物品重量	物品价值
    //        1		   2		3
    //        2		   3		4
    //        3		   4		5
    //        4		   5		8
    public static int findMaxValue(int[] weight, int[] value, int bag) {
        int[] dp = new int[bag + 1];
        for(int i = 0; i < weight.length; i++){
            for(int j = weight[i]; j <= bag; j++){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bag];
    }

    public static void main(String[] args) {
        int maxValue = findMaxValue(new int[]{2,3,4,5}, new int[]{3,4,5,8}, 8);
        System.out.println(maxValue);
    }

    // 518. Coin Change II
    // 排列与组合问题   组合：无顺序敏感性   排列：顺序敏感
    // 完全背包的组合：先遍历物品，再遍历背包   只会有 [1, 2] 这种情况
    // 完全背包的排列：先遍历背包，再遍历物品   会出现 [1, 2] 与 [2, 1] 两种情况
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    // 377. Combination Sum IV
    // 爬楼梯和本题一样，一次爬一个，一个爬两个，一次爬n个。就是nums数组，问有多少种爬楼方法
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for(int j = 0; j <= target; j++){
            for(int i = 0;i < nums.length; i++){
                if(j < nums[i])continue;
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    // 322. Coin Change
    // 取最大值时，dp中元素都要初始化为0；取最小值时，dp中元素都要初始化为Integer.MAX_VALUE; 元素0都单独看。
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要, 不然整数最大值溢出了
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    // 279. Perfect Squares
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i * i <= n; i++){
            for(int j = i * i; j <= n; j++){
                if(dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

    // 139. Word Break
    // 顺序敏感，所以要先遍历背包再遍历物品
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(wordDict.contains(s.substring(j ,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}