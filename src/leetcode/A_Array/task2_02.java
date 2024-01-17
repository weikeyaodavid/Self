package leetcode.A_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task2_02 {
    //18
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b - a > 1 && nums[b] == nums[b - 1]) continue;
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    int tmp = nums[a] + nums[b] + nums[c] + nums[d];
                    if (tmp == target) {
                        List<Integer> tmpList = new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        res.add(tmpList);
                        while (c < d && nums[c] == nums[c + 1]) c += 1;
                        while (c < d && nums[d] == nums[d - 1]) d -= 1;
                        c += 1;
                        d -= 1;
                    } else if (tmp > target) d -= 1;
                    else c += 1;
                }
            }
        }
        return res;
    }

    //27
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
        //一次遍历，只获取符合条件的值改变当前index，快慢指针

//        Arrays.sort(nums);
//        int flag = 0;
//        int end = nums.length - 1;
//        for(int a = 0; a < nums.length; a++){
//            if(nums[a] != val)continue;
//            if(nums[a] == val){
//                if(nums[end - flag] == val)return a;
//                nums[a] = nums[end - flag];
//                flag++;
//                if(a == end - flag)return a + 1;
//            }
//        }
//        return nums.length - flag;
    }

    //977. Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    public static void main(String[] args) {
        fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        removeElement(new int[]{2, 3, 3}, 2);
    }
}
