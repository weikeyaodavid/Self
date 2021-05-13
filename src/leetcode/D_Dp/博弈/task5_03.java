package leetcode.D_Dp.博弈;

public class task5_03 {

    //292. Nim Game
    public boolean canWinNim(int n) {
         //dp会超时
         boolean[] dp = new boolean[Math.max(n + 1, 4)];
         dp[1] = dp[2] = dp[3] = true;
         for(int i = 4; i <= n; i++){
             dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
         }
         return dp[n];
    }



}
