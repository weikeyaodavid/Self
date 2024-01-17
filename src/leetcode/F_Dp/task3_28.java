package leetcode.F_Dp;

import java.util.Arrays;
import java.util.List;

public class task3_28 {

    //322. Coin Change
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    //139. Word Break
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }



    //279. Perfect Squares
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = i;
            for(int j = 1; i - j * j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
