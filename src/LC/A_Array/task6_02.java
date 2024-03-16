package LC.A_Array;

import java.util.Arrays;

public class task6_02 {

    //4. Median of Two Sorted Arrays  没彻底搞懂 待重写
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            return findKth(nums1, nums2, (length + 1) / 2);
        } else {
            return (findKth(nums1, nums2, (length + 1) / 2) + findKth(nums1, nums2,
                    (length + 2) / 2)) / 2;
        }
    }

    private double findKth(int[] nums1, int[] nums2, int k) {

        if (nums1.length == 0)
            return nums2[k - 1];
        if (nums2.length == 0)
            return nums1[k - 1];
        if (k == 1)
            return Math.min(nums2[k - 1], nums1[k - 1]);

        int k1 = Math.min(nums1.length, k / 2);
        int k2 = Math.min(nums2.length, k - k / 2);

        if (nums1[k1 - 1] < nums2[k2 - 1]) {
            return findKth(Arrays.copyOfRange(nums1, k1, nums1.length), nums2, k - k1);
        } else {
            return findKth(nums1, Arrays.copyOfRange(nums2, k2, nums2.length), k - k2);
        }
    }

    //42. Trapping Rain Water
    public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
