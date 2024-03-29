package LC.F_Dp;

public class task4_06 {

    //5. Longest Palindromic Substring
    //核心思想 回文删除左右两边的字母也一定是回文
    //        单个字母和空一定是回文
    //回文问题dp的话也使用二维数组
    public String longestPalindrome(String s) {
        if(s.length() <= 1)return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;   //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
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

    //256. Paint House
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i = 1; i < costs.length; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
        }
        return Math.min(Math.min(dp[costs.length - 1][0], dp[costs.length - 1][1]), dp[costs.length - 1][2]);
    }

    // 补充题2.圆环回原点问题
    // 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
    public int circleSteps(int n, int k){
        // 圆环中有n个节点，走k步回答原点有几种走法
        // 走k步走到0的走法=走k-1步走到1的走法 + 走k-1步走到num-1的走法
        // dp[i][j]表示走i步走到j点的走法种类
        // dp[i][j] = dp[i-1][(j+1)%len] + dp[i-1][(j-1+len)%len]
        // ps:公式之所以取余是因为j-1或j+1可能会超过圆环0~9的范围
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for(int i=1; i<=k; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = dp[i-1][(j+1)%n] + dp[i-1][(j-1+n)%n];
            }
        }
        return dp[k][0];
    }
}
