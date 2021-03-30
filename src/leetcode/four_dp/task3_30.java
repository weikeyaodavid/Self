package leetcode.four_dp;

import java.util.Arrays;
import java.util.Stack;

public class task3_30 {

    //198. House Robber
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[0] = 0;
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }


    //213. House Robber II
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        int max = dp[dp.length - 1];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(max, dp[dp.length - 1]);
    }


    //20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(")");
            } else if (s.charAt(i) == '{') {
                stack.add("}");
            } else if (s.charAt(i) == '[') {
                stack.add("]");
            } else if (s.charAt(i) == ']') {
                if (stack.empty() || !stack.pop().equals("]")) return false;
            } else if (s.charAt(i) == '}') {
                if (stack.empty() || !stack.pop().equals("}")) return false;
            } else if (s.charAt(i) == ')') {
                if (stack.empty() || !stack.pop().equals(")")) return false;
            }
        }
        return stack.empty();
    }


    //91. Decode Ways
    // 这一类问题，问方案数，但不问具体方案的，可以考虑使用「动态规划」完成；
    //「动态规划」处理字符串问题的思想是：从一个空串开始，一点一点得到更大规模的问题的解。
    public int numDecodings(String s) {
        if(s.equals("0") || s.charAt(0)=='0')return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    if(i > 1)dp[i] = dp[i - 2];
                    else dp[i] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && Integer.parseInt(String.valueOf(s.charAt(i))) <= 6)) {
                    if(i > 1)dp[i] = dp[i - 1] + dp[i - 2];
                    else dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }



    public int minCut(String s) {
                int len = s.length();
                if (len < 2) {
                    return 0;
                }
                int[] dp = new int[s.length()];
                Arrays.fill(dp, s.length());
                dp[0] = 0;
                for(int i = 1; i < s.length(); i++){
                    if(checkPalindrome(s, 0, i)){
                        dp[i] = 0;
                        continue;
                    }
                    for(int j = 0; j < i; j++){
                        if(checkPalindrome(s, j + 1, i))
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
}


