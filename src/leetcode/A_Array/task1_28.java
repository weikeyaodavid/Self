package leetcode.A_Array;

public class task1_28 {
    //80
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

    //81
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
