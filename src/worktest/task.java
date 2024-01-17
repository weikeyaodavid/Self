package worktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(nums[right] == val && right > left)right--;
        for(int i = 0; i < right; i++){
            if(nums[i] == val){
                nums[i] = nums[right];
                right--;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {

    }
}
