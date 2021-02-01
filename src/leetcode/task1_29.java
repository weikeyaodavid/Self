package leetcode;

import java.util.*;

public class task1_29 {

    //15
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 1] == nums[i]) continue;
            HashSet<Integer> set = new HashSet<>();
            for (int a = i + 1; a < nums.length; a++) {
                if(i != nums.length - 2 && nums[i + 1] == nums[i])continue;
                if (set.contains((-nums[i] - nums[a]))) {
                    List<Integer> part = new ArrayList<>();
                    part.add(nums[i])
                    part.add(nums[a]);
                    part.add(-nums[i] - nums[a]);
                    all.add(part);
                } else {
                    set.add(nums[a]);
                }
            }
        }
        return all;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
