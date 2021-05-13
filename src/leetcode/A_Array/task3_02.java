package leetcode.A_Array;

public class task3_02 {

    //73
    public static void setZeroes(int[][] matrix) {
        int x = matrix[0].length;
        int y = matrix.length;
        boolean xt = false;
        boolean yt = false;
        for(int b = 0; b < y; b++){
            if(matrix[b][0] == 0){
                yt = true;
                break;
            }
        }
        for(int a = 0; a < x; a++) {
            if (matrix[0][a] == 0) {
                xt = true;
                break;
            }
        }
        for(int b = 0; b < y; b++){
            for(int a = 0; a < x; a++){
                if(matrix[b][a] == 0){
                    matrix[b][0] = 0;
                    matrix[0][a] = 0;
                }
            }
        }
        for(int b = 1; b < y; b++){
            for(int a = 1; a < x; a++){
                if(matrix[0][a] == 0 || matrix[b][0] == 0){
                    matrix[b][a] = 0;
                }
            }
        }
        for(int b = 0; b < y; b++){
            if(yt){
                for(int q = 0; q < y; q++){
                    matrix[q][0] = 0;
                }
                break;
            }
        }
        for(int a = 0; a < x; a++) {
            if (xt) {
                for (int q = 0; q < x; q++) {
                    matrix[0][q] = 0;
                }
                break;
            }
        }
    }
    //注意边界情况


    //74
    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix[0].length;
        int y = matrix.length;
        int left = 0;
        int right = x * y - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(matrix[mid / x][mid % x] == target)return true;
            if(matrix[mid / x][mid % x] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    //二维变成一维,就是按照二维数组顺序,依次变成一维数列,所以有如果一个数在一维坐标位置是loc,那么它在二维坐标就是[loc/col][loc%col]
    //注意是-除列数

    //mid值求法使用  mid = left + (right - left) / 2
    //防止两值相加过大而溢出


    //75
    public static void sortColors(int[] nums) {
        int end = nums.length - 1;
        for(int i = 0; i <= end; i ++){
            if(nums[i] == 2){
                int a = end;
                while(a > i && nums[a] == 2)a--;
                swap(nums, i, a);
                if(nums[i] == 0)i--;
            }else if(nums[i] == 0){
                int a = 0;
                while(a < i && nums[a] == 0)a++;
                swap(nums, i, a);
                if(nums[i] == 2)i--;
            }
        }
    }
    public static void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

//    双指针
//    public void sortColors(int[] nums) {
//        int n = nums.length;
//        int p0 = 0, p2 = n - 1;
//        for (int i = 0; i <= p2; ++i) {
//            while (i <= p2 && nums[i] == 2) {
//                int temp = nums[i];
//                nums[i] = nums[p2];
//                nums[p2] = temp;
//                --p2;
//            }
//            if (nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[p0];
//                nums[p0] = temp;
//                ++p0;
//            }
//        }
//    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        searchMatrix(new int [][]{{1,1}},2);
        sortColors(new int[]{1,2,0});
    }
}

