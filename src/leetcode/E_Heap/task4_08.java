package leetcode.E_Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

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


    //347. Top K Frequent Elements
    //改造堆的构造器
    //PriorityQueue<Integer> minHeat = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Integer> minHeat = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (minHeat.size() < k) {
                minHeat.add(key);
            } else if (map.get(key) > map.get(minHeat.peek())) {
                minHeat.remove();
                minHeat.add(key);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = minHeat.poll();
        }
        return res;
    }
}
