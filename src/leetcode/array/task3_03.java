package leetcode.array;

import java.util.*;

public class task3_03 {

    //88
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0;
        int b = 0;
        while(a < m && b <n ){
            if(nums1[a] > nums2[b]){
                int temp = nums1[a];
                nums1[a] = nums2[b];
                nums2[b] = temp;
                if(temp == 0)b++;
                a++;
                Arrays.sort(nums2);
            }else{
                a++;
            }
        }
        while(b < n){
                nums1[a] = nums2[b];
                a++;
                b++;
        }
    }

    //三指针，从后向前
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        // 三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
//        // 1.当，p1>=0时，nums[p1],nums[p2]对比
//        // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
//        // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
//        // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
//        // 循环结束条件：p2<0
//
//        int p1=m-1,p2=n-1,p3=m+n-1;
//        while(p2 >= 0){
//            if(p1 >= 0 && nums1[p1] > nums2[p2]){
//                nums1[p3--] = nums1[p1--];
//            } else {
//                nums1[p3--] = nums2[p2--];
//            }
//        }
//    }


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
