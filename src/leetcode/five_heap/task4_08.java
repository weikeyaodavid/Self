package leetcode.five_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class task4_08 {

    //剑指 Offer 40. 最小的k个数  LCOF
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0)return new int[]{};
        PriorityQueue<Integer> maxHeat = new PriorityQueue<>((a, b) -> b - a);
        for (int j : arr) {
            if(maxHeat.size() < k){
                maxHeat.add(j);
            }else {
                if(j < maxHeat.peek()){
                    maxHeat.poll();
                    maxHeat.add(j);
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < maxHeat.size(); i++){
            res[i] = maxHeat.poll();
        }
        return res;
    }


    //215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeat = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            if(maxHeat.size() < k){
                maxHeat.add(nums[i]);
            }else{
                if(maxHeat.peek() < nums[i]){
                    maxHeat.poll();
                    maxHeat.add(nums[i]);
                }
            }
        }
        return maxHeat.peek();
    }
}
