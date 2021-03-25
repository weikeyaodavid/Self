package leetcode.four_dp;

public class task3_25 {

    //322. Coin Change
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int coin = 0; coin < coins.length; coin++){
                if(coins[coin] < amount){
                    dp[i] = Math.min(dp[i], dp[i - coins[coin]] + 1);
                }
            }
        }

        return 0;
    }
}
