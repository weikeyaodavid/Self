package leetcode.A_Array;

public class task2_03 {

    //31
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstIndex = -1;
        for(int a = nums.length - 2; a >= 0; a--){
            if(nums[a] < nums[a + 1]){
                firstIndex = a;
                break;
            }
        }
        if(firstIndex == -1){
            reverce(nums, 0, nums.length - 1);
            return;
        }
        int secondIndex = 0;
        for(int b = nums.length - 1; b >= 0; b--){
            if(nums[firstIndex] < nums[b]){
                secondIndex = b;
                break;
            }
        }
        swap(firstIndex, secondIndex, nums);
        reverce(nums, firstIndex + 1, nums.length - 1);
    }

    public void reverce(int []nums, int a, int b){
        while(a < b){
            swap(a, b, nums);
            a++;
            b--;
        }
    }

    public void swap(int a, int b, int [] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //字典序：找出这个数组排序出的所有数中，刚好比当前数大的那个数
    //比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，比123大的那个数 也就是132
    //如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，那么就返回1，2，3排序后所有数中最小的那个，也就是1，2，3 -> [1,2,3]

    //先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组；（最大索引的意思是从后往前找）
    //再找出另一个最大索引 l 满足 nums[l] > nums[k]；
    //交换 nums[l] 和 nums[k]；
    //最后翻转 nums[k+1:]。


    //34
    public static int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }


        private static int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 小于一定不是解
                if (nums[mid] < target) {
                    // 下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // nums[mid] > target，下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                }
            }

            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private static int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    // 下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                } else if (nums[mid] == target){
                    // 下一轮搜索区间是 [mid, right]
                    left = mid;
                } else {
                    // nums[mid] < target，下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                }
            }
            return left;
        }
            //二分法套路

//          int left = 0;
//          int right = nums.length - 1;
//          while (left < right) {
//              int mid = left + (right - left + 1) / 2;
//          然后仔细考虑  nums[mid] = target 的情况
//                  与   left = mid /  right = mid  是否 -1

    public static void main(String[] args) {
        searchRange(new int[]{1}, 1);
    }
}
