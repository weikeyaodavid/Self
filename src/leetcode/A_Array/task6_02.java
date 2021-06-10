package leetcode.A_Array;

public class task6_02 {

    //4. Median of Two Sorted Arrays  没彻底搞懂 待重写
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        if(a > b)return findMedianSortedArrays(nums2, nums1);

        int c1 = 0;
        int c2 = 0;
        int left = 0;
        int right = a;

        while(left <= right){
            c1 = (left + right + 1) / 2;
            c2 = (a + b) / 2 - c1;

            int leftc1 = c1 == 0 ? Integer.MIN_VALUE : nums1[c1 - 1];
            int rightc1 = c1 == b - 1 ? Integer.MAX_VALUE : nums1[c1];
            int leftc2 = c2 == 0 ? Integer.MIN_VALUE : nums1[c2 - 1];
            int rightc2 = c2 == a - 1 ? Integer.MAX_VALUE : nums1[c2];
            if(leftc1 > rightc2){
                right = c1 - 1;
            }else if(rightc1 < leftc2){
                left = c1 + 1;
            }else {
                break;
            }
        }

        if((a + b) % 2 == 0)return (double) (Math.max(nums1[c1 - 1], nums2[c2 - 1]) + Math.min(nums1[c1], nums2[c2])) / 2;
        else return Math.max(nums1[c1 - 1], nums2[c2 - 1]);
    }
}
