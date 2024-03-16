package LC.F_Dp;

public class task3_24 {

    //509. Fibonacci Number
    //斐波那契数列 当前值只与前两个数相关 所以不需要很长的dp table来记录每一个值
    public int fib(int n) {
        if(n < 2)return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //70. Climbing Stairs
    //当前值只与前两个数相关 所以不需要很长的dp table来记录每一个值
    public int climbStairs(int n) {
        if(n < 3)return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 746. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= dp.length - 1; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    //62. Unique Paths
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)dp[i][0] = 1;
        for(int i = 0; i < n; i++)dp[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //63. Unique Paths II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < dp.length; i++){
            if(obstacleGrid[i][0] != 1)dp[i][0] = 1;
            else break;
        }
        for(int i = 0; i < dp[0].length; i++){
            if(obstacleGrid[0][i] != 1)dp[0][i] = 1;
            else break;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(obstacleGrid[i][j] == 1)continue;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    // 343. Integer Break
    public int integerBreak(int n) {
        if(n == 2)return n - 1;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            int max = 0;
            for(int j = i - 1; j >= 1;j--){
                dp[i] = Math.max(j * (i - j), j * dp[i - j]);
                max = Math.max(max, dp[i]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    // 96. Unique Binary Search Trees
    public int numTrees(int n) {
        if(n < 3)return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
