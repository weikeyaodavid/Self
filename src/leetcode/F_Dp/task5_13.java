package leetcode.F_Dp;

public class task5_13 {
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

    //718. Maximum Length of Repeated Subarray
    public int findLength(int[] nums1, int[] nums2) {
        return 0;
    }
}
