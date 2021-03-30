package leetcode.four_dp;

import java.util.HashMap;
import java.util.Stack;

public class task3_30 {

    //198. House Robber
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[0] = 0;
        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }


    //213. House Robber II
    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        int max = dp[dp.length - 1];
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(max, dp[dp.length - 1]);
    }


    //20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add(")");
            }else if(s.charAt(i) == '{'){
                stack.add("}");
            }else if(s.charAt(i) == '['){
                stack.add("]");
            }else if(s.charAt(i) == ']'){
                if(stack.empty() || !stack.pop().equals("]"))return false;
            }else if(s.charAt(i) == '}'){
                if(stack.empty() || !stack.pop().equals("}"))return false;
            }else if(s.charAt(i) == ')'){
                if(stack.empty() || !stack.pop().equals(")"))return false;
            }
        }
        return stack.empty();
    }


    //413. Arithmetic Slices
    public int numberOfArithmeticSlices(int[] nums) {


    }
}
