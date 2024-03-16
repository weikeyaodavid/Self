package LC.A_Array;

public class task2_04 {

    //35
    // left 和 right 最后是反的
    public static int searchInsert(int[] nums, int target) {
        int first = 0;
        int end = nums.length - 1;
        int mid;
        while(first <= end){
            mid = (first + end) / 2;
            if(nums[mid] == target)return mid;
            if(nums[mid] < target){
                first = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        searchInsert(new int[]{1,3,5,6}, 2);
    }
}
