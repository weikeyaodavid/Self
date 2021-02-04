package leetcode;

import java.util.Arrays;

public class task2_01 {
    //16
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    //11
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while(start < end){
            if(height[start] <= height[end]){
                int acc = (end - start) * Math.min(height[end], height[start]);
                if(res < acc){
                    res = acc;
                }
                start++;
            } else {
                int acc = (end - start) * Math.min(height[end], height[start]);
                if(res < acc){
                    res = acc;
                }
                end--;
            }
        }
        return res;
    }
//    直觉告诉我们，应该移动对应数字较小的那个指针（即此时的左指针）。这是因为，由于容纳的水量是由
//    两个指针指向的数字中较小值指针之间的距离
//    两个指针指向的数字中较小值指针之间的距离
//    决定的。如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，
//    后者「指针之间的距离」会减小，那么这个乘积会减小。因此，我们移动数字较大的那个指针是不合理的。因此，我们移动 数字较小的那个指针。

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}

