package leetcode.one_array;

import java.util.*;

public class task1_29 {

    //1
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1 || nums == null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey((target - nums[i]))) {
                return new int[]{map.get((target - nums[i])), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    //15
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<>();
        for (int a = 0; a < nums.length - 2; a++) {
            int b = a + 1;
            int c = nums.length - 1;
            if (nums[a] > 0 || nums[c] < 0) return all;
            if(a > 0 && nums[a] == nums[a - 1]) continue;
            while (b < c && a < b) {
                if (nums[a] + nums[b] + nums[c] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[a]);
                    res.add(nums[b]);
                    res.add(nums[c]);
                    all.add(res);
                    while(b < c && nums[b] == nums[++b]);
                    while(b < c && nums[c] == nums[--c]);
                }else if (nums[a] + nums[b] + nums[c] < 0) {
                    while(b < c && nums[b] == nums[++b]);
                }else if (nums[a] + nums[b] + nums[c] > 0) {
                    while(b < c && nums[c] == nums[--c]);
                }
            }
        }
        return all;
    }
    //       这种写法时间超出限制
    //       while( nums[b] == nums[b+1] && b < c){
    //        b++;
    //        }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,0,-1,0,-2,2}).toString());
    }
}
