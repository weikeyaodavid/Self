package leetcode.four_dp;

public class task3_24 {

    //70. Climbing Stairs
    //当前值只与前两个数相关 所以不需要很长的dp table来记录每一个值
    public int climbStairs(int n){
        int pre = 1;
        int cur = 1;
        int sum = 0;
        if(n < 2)return n;
        for(int i = 2; i <= n; i++){
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }


    //509. Fibonacci Number
    //斐波那契数列 当前值只与前两个数相关 所以不需要很长的dp table来记录每一个值
    public int fib(int n) {
        if(n < 2)return n;
        int sum = 0;
        int pre = 0;
        int cur = 1;
        for(int i = 2; i <=n; i++){
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
