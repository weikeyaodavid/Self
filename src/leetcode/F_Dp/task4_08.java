package leetcode.F_Dp;

public class task4_08 {

    //55. Jump Game
    //从中间或末尾状态想
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && (nums[j] + j >= i);
                if (dp[i]) break;
            }
        }
        return dp[dp.length - 1];
    }


    //45. Jump Game II
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }


    //背包问题框架
    //0 - 1 背包问题  每种物品只可以取一次
    //int dp[N+1][W+1]
    //dp[0][..] = 0
    //dp[..][0] = 0
    //
    //for i in [1..N]:
    //    for w in [1..W]:
    //        dp[i][w] = max(
    //            把物品 i 装进背包,  dp[i-1][w],
    //            不把物品 i 装进背包  dp[i-1][w - wt[i-1]] + val[i-1]
    //        )
    //return dp[N][W]
    //dp[i][w]的定义如下：对于前i个物品，当前背包的容量为w，这种情况下可以装的最大价值是dp[i][w]。
    //
    //比如说，如果 dp[3][5] = 6，其含义为：对于给定的一系列物品中，若只对前 3 个物品进行选择，当背包容量为 5 时，最多可以装下的价值为 6。
    public static void main(String[] args) {
        int[] value = new int[]{1500, 3000, 2000};
        int[] weight = new int[]{1, 4, 3};
        int maxBag = 4;
        int[][] dp = new int[value.length + 1][maxBag + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= maxBag; j++) {
                if (weight[i - 1] - j > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        System.out.println(dp[value.length][maxBag]);
    }


    //518. Coin Change 2
    //完全背包问题
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < amount + 1; i++) dp[0][i] = 0;
        for (int i = 0; i < coins.length + 1; i++) dp[i][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[coins.length][amount];
    }

}
