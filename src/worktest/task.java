package worktest;

import sun.misc.InvalidJarIndexException;

import java.util.List;

public class task {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,4,4,4,4,5};
        if(nums.length < 3){
            System.out.println(nums.length);
        }
        int slow = 0;
        for (int fast : nums) {
            if (slow < 2 || nums[slow - 2] != fast) {
                nums[slow] = fast;
                slow++;
            }
        }
        for(int i = 0; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
