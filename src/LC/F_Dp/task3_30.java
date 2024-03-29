package LC.F_Dp;

import java.util.Arrays;

public class task3_30 {

    //91. Decode Ways
    // 这一类问题，问方案数，但不问具体方案的，可以考虑使用「动态规划」完成；
    //「动态规划」处理字符串问题的思想是：从一个空串开始，一点一点得到更大规模的问题的解。
    public int numDecodings(String s) {
        if (s.equals("0") || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    if (i > 1) dp[i] = dp[i - 2];
                    else dp[i] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && Integer.parseInt(String.valueOf(s.charAt(i))) <= 6)) {
                    if (i > 1) dp[i] = dp[i - 1] + dp[i - 2];
                    else dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }


    //132. Palindrome Partitioning II
    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, s.length());
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (checkPalindrome(s, 0, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (checkPalindrome(s, j + 1, i))
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //ByteDance
    // 圆环上有 10 个点，编号为0 ~ 9。从 0 出发，
    // 每次可以逆时针和顺时针走一步，问走 n 步回到 0 共有多少种走法。
    public int findPath(int n){
        int[][] dp = new int[n + 1][10];
        dp[0][0] = 1;
        for(int a = 1; a <= n; a++){
            for(int b = 0; b < 10; b++){
                //dp[a][b] 代表走 a 步到达 b
                dp[a][b] = dp[a - 1][(b - 1 + n) % n] + dp[a - 1][(b + 1) % n];
            }
        }
        return dp[n][0];
    }
}


