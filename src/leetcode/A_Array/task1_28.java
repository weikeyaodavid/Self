package leetcode.A_Array;

public class task1_28 {
    //80 Remove Duplicates from Sorted Array II
    /*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element
    appears at most twice. The relative order of the elements should be kept the same.
    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in
    the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements
    of nums should hold the final result. It does not matter what you leave beyond the first k elements.
    Return k after placing the final result in the first k slots of nums.
    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
    [0,0,1,1,1,1,2,3,4,4,4,4]
     */

    //81. Search in Rotated Sorted Array II
    /*
    There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
    Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the
    resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example,
    [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
    Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
    You must decrease the overall operation steps as much as possible.
     */


















    public static int[] removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast : nums) {
            if (slow < 2 || nums[slow - 2] != fast) {
                nums[slow] = fast;
                slow++;
            }
        }
        return nums;
    }
    /*
        只要修改数和两个数前的值相同就需要替换，变成目标值
    */
    public int removeDuplicates2(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }
        int count = 1;
        int modify = 0;
        for(int originCount = 1; originCount < nums.length; originCount++){
            if(nums[originCount] == nums[originCount - count]){
                count++;
                if(count>2){
                    modify++;
                }
            }else{
                count = 1;
            }
            nums[originCount-modify] = nums[originCount];
        }
        return nums.length - modify;
    }

    public static boolean search(int[] nums, int target) {
        int first = 0;
        int end = nums.length - 1;
        int mid;
        while (first <= end) {
            mid = (first + end) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] > nums[first]) {
                if (nums[first] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else if (nums[mid] < nums[first]) {
                if (nums[mid] < target && target <= nums[end]) {
                    first = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                first = first + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
