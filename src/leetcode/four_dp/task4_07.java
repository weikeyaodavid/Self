package leetcode.four_dp;

public class task4_07 {

    //5. Longest Palindromic Substring
    //核心思想 回文删除左右两边的字母也一定是回文
    //        单个字母和空一定是回文
    //回文问题dp的话也使用二维数组
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int max = 1;
        String ans = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 >= max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    //dp[i][j]
    //最长子集和最长子序列的区别是   子集二维数组都记录自己i，j范围内的值  子序列都记录自己i,j范围内最大的值

    //516. Longest Palindromic Subsequence
    //https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484666&idx=1&sn=e3305be9513eaa16f7f1568c0892a468&chksm=9bd7faf2aca073e4f08332a706b7c10af877fee3993aac4dae86d05783d3d0df31844287104e&scene=21#wechat_redirect
    //状态转移方程，想求dp[i][j]需要知道dp[i+1][j-1]，dp[i+1][j]，dp[i][j-1]
    //为了保证每次计算dp[i][j]，左、下、左下三个方向的位置已经被计算出来，只能斜着遍历或者反着遍历
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
