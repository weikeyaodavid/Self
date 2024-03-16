/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package LC.F_Dp;

/**
 *
 * @author weikeyao
 * @version task3_25.java, v 0.1 2024年01月13日 23:13 weikeyao
 */
public class task3_25 {
    // 0-1背包问题
    // https://www.bilibili.com/video/BV1g7411B7SP/?spm_id_from=333.337.search-card.all.click&vd_source=30813cdd3968362721bd4b3ad6e4ba94
    // https://www.bilibili.com/video/BV1BU4y177kY/?p=103&spm_id_from=pageDriver
    // 现在有四种物品，每种物品只有1件，它们的重量与价值如下表。
    // 现在有一个背包，总容量为8。问怎么选取物品，可以使得背包装的物品价值最大？
    //    物品编号	物品重量	物品价值	物品数量
    //        1		   2		3		1
    //        2		   3		4		1
    //        3		   4		5		1
    //        4		   5		8		1
    public static int findMaxValue(int[] weight, int[] value, int bag) {
        // 1. dp[当前可放置的物品][当前背包容量]
        int[][] dp = new int[weight.length][bag + 1];

        // 2. 初始化数组
        // 放置各个物品时 容量0情况下的最大价值
        for(int i = 0; i < weight.length; i++){
            dp[i][0] = 0;
        }
        // 放置物品0时 各个容量下的最大价值
        for(int j = 0; j <= bag; j++){
            if(j >= weight[0]) dp[0][j] = value[0];
        }

        // 3. 当前情况下的最大值为放或不放当前物品
        // 不放当前物品：dp[i - 1][j]  前一个物品的最大值
        // 放当前物品： dp[i - 1][j - weight[i]] + value[i]  不放当前物品容量下的最大值 + 当前物品价值
        for(int i = 1; i < weight.length; i++){
            for(int j = 1; j <= bag; j++){
                if(j < weight[i]){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[weight.length - 1][bag];
    }

    // 一维数组优化
    public static int findMaxValueOptimize(int[] weight, int[] value, int bag) {
        // 1. dp[当前背包容量]
        int[] dp = new int[bag + 1];

        // 2. 当前情况下的最大值为放或不放当前物品

        // 正序遍历用一个物品塞满背包，每次覆盖的数据都是同一个物品塞满的情况
        // 反向遍历就是每次只塞一个，并且比较的数据只来自上一轮，以及当前的value[i]

        // 为什么二维不需要倒序呢？
        // 二维数组取值为正上方和左上方，所以不需要倒序。一维数组倒序的话可以保证每一层数据也是由上一层正上方和左上方得出的（上一轮结果）

        // 为什么只能物品放最外层，容量只能放最内层呢？
        // 先遍历物品再遍历背包：填空顺序是，先写第一行（从右往左写），再写第二行的时候，你的左边是有数字的。。。
        // 先遍历物品再遍历背包：从右到左地遍历背包容量：相当于你的计算顺序是先竖着写完第四列，再竖着写完第三列，再竖着写完第二列。。。但你写第四列的时候，第三列全部都是空的，左边是没有数据的，你永远只在累加正上方的数。
        for(int i = 0; i < weight.length; i++){
            for(int j = bag; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bag];
    }

    public static void main(String[] args) {
        int maxValue = findMaxValueOptimize(new int[]{2,3,4,5}, new int[]{3,4,5,8}, 8);
        System.out.println(maxValue);
    }

    // 416. Partition Equal Subset Sum
    // 背包要放入的商品（集合里的元素）重量 和 价值 都为元素的数值
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        if(sum % 2 != 0)return false;

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    // 1049. Last Stone Weight II
    // 分成重量差不多相等了两堆，相撞和最小
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0; i < stones.length; i++){
            sum = sum + stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < stones.length; i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }

    // 494. Target Sum
    // 问装满有多少种方法的问题：dp[j] 代表装满 j 容量的包有几种方法
    // 1. 当不能装下nums[i]时,方案数直接继承之前的dp[j]
    // 2. 当能装下nums[i]时,总的方案数为不考虑nums[i]的方案数+有nums[i]参与新增的方案数
    // 3. 状态初始化:dp[0]=1, 装满背包为0的方法种类有一种。装满背包容量为0的背包可以什么也不装，就是一种方法
    // 因为后面总会一直查找至j=0,如dp[3] += dp[3-3],空集是任意一条有效路径的起点,当属一条
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int required = (target + sum) / 2;
        if((target + sum) % 2 != 0 || Math.abs(target) > sum)return 0;

        int[] dp = new int[required + 1];
        // 状态初始化:dp[0]=1,因为后面总会一直查找至j=0,如dp[3] += dp[3-3],空集是任意一条有效路径的起点,当属一条
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = required; j >= nums[i]; j--){
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[required];
    }

    // 474. Ones and Zeroes
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}
