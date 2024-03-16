package LC.A_Array;

import java.util.*;

public class task3_03 {

    //88
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int one = m - 1;
        int two = n - 1;
        for(int i = nums1.length - 1; i >= 0 && two >= 0 && one >= 0; i--){
            if(nums1[one] >= nums2[two]){
                nums1[i] = nums1[one];
                one--;
            }else{
                nums1[i] = nums2[two];
                two--;
            }
        }
        if(one < 0){
            for(int i = 0; i <= two; i++){
                nums1[i] = nums2[i];
            }
        }
    }



    //202
    public static boolean isHappy(int n) {
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        while(true) {
            while (n / 10 > 0) {
                int x = (int) Math.pow(n % 10, 2);
                sum = sum + x;
                n = n / 10;
            }
            int x = (int) Math.pow(n % 10, 2);
            sum = sum + x;
            if (sum == 1) return true;
            else if (res.contains(sum)) return false;
            res.add((int) sum);
            n = sum;
            sum = 0;
        }
    }


    //349
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = nums1.length - 1;
        int b = nums2.length - 1;
        int c = 0;
        int d = 0;
        Set<Integer> res = new HashSet<>();
        while(c <= a && d <= b ){
            if(nums1[c] > nums2[d]){
                d++;
            }else if(nums1[c] < nums2[d]){
                c++;
            }else{
                res.add(nums2[d]);
                d++;
                c++;
            }
        }
        return res.stream().mapToInt(i ->i).toArray();
    }

    public static void main(String[] args) {
        merge(new int[]{0,0,3,0,0,0,0}, 3, new int[]{2,5,6}, 3);
        isHappy(19);
    }
}
