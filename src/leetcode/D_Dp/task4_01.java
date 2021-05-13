package leetcode.D_Dp;

import java.util.ArrayList;
import java.util.List;

public class task4_01 {

    //122. Best Time to Buy and Sell Stock II
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }



    //123. Best Time to Buy and Sell Stock III
    //没理解
    public int maxProfit3(int[] prices) {
        if(prices.length == 1)return 0;
        int min = prices[0];
        List<Integer> profit = new ArrayList<>();
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= prices[i - 1] && i == prices.length - 1){
                profit.add(prices[i] - min);
            }else if(prices[i] < prices[i - 1]){
                profit.add(prices[i - 1] - min);
                min = prices[i];
            }
        }

        int max = 0;
        int max2 = 0;
        if(profit.size() == 1)return profit.get(0);
        if(profit.size() == 2)return profit.get(0) + profit.get(1);

        for(int i = 0; i < profit.size(); i++){
            max = Math.max(max, profit.get(i));
        }
        profit.remove(profit.indexOf(max));
        for(int i = 0; i < profit.size(); i++){
            max2 = Math.max(max2, profit.get(i));
        }
        return max + max2;
    }
}
