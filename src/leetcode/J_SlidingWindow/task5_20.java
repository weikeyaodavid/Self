package leetcode.J_SlidingWindow;

public class task5_20 {

    //718. Maximum Length of Repeated Subarray
    public int findLength(int[] nums1, int[] nums2) {
        return  nums1.length > nums2.length ? find(nums2, nums1) : find(nums1, nums2);
    }
    public int find(int[] a1, int[] b1){
        int l1 = a1.length - 1;
        int l2 = b1.length - 1;
        int max = 0;
        //窗口滑动的重叠过程可以分为三个过程：
        //1、下面子串进入，开始重叠的过程
        //2、上下两子串完全重叠，中间过程
        //3、下面的子串开始离开，重叠区域减少，离开过程
        for(int i = 0; i <= l1; i++){
            max = Math.max(max, findMax(a1, 0, b1, l2 - i, i));
        }
        for(int i = l2 - l1; i >= 0; i--){
            max = Math.max(max, findMax(a1, 0, b1, i, l1));
        }
        for(int i = l1; i >= 0; i--){
            max = Math.max(max, findMax(a1, l1 - i, b1, 0, i));
        }
        return max;
    }
    public int findMax(int[] a, int l1, int[] b, int l2, int len){
        int max = 0;
        int count = 0;
        for (int i = 0; i <= len; i++){
            if(a[l1 + i] == b[l2 + i]){
                count++;
                max = Math.max(max, count);
            }else {
                count = 0;
            }
        }
        return max;
    }



    //209. Minimum Size Subarray Sum
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(right < nums.length){
            sum = sum + nums[right];
            while(sum >= target && left <= right){
                res = Math.min(res, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
