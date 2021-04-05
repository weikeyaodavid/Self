package leetcode.four_dp;

public class task4_05 {

    //1143. Longest Common Subsequence
    //子序列问题一般都是动态规划
    //经典题
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    //97. Interleaving String
    //当两个数组或者字符串要用动态规划时，可以把动态规划定义成两维的 dp[i][j]
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length() && s1.charAt(i-1) == s3.charAt(i-1); i++) dp[i][0] = true; // 不相符直接终止
        for (int j = 1; j <= s2.length() && s2.charAt(j-1) == s3.charAt(j-1); j++) dp[0][j] = true; // 不相符直接终止

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
