package leetcode;

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
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int leftLimit;

        while(start < end){
            mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            leftLimit = start;
        }
        while(start < end){
            mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid;
            }
        }
        if(nums[end] == target){
            leftLimit = end;
        }


        return null;
    }


    public static void main(String[] args) {

    }
}
