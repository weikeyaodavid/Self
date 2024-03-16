package LC.A_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class task3_01 {

    //56
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1 || intervals.length == 0 || intervals == null || intervals[0].length == 0) return intervals;
        List<int[]> res = new ArrayList<>();
        int length = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

//        List<int[]> inter = Arrays.asList(intervals);
//        List<int[]> newInter = new ArrayList<>(inter);
//        newInter.sort((o1, o2) -> o1[0] - o2[0]);

        int i = 0;
        while(i < length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < length - 1 && right > intervals[i + 1][0]){
                right = Math.max(intervals[i + 1][1], right);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int [res.size()][]);
    }

    //二维数组按首个元素排序
    //Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    //二维数组初始化必须提供至少一个纬度的长度
    //用 list <int []> 先代替

    //关键点---左边一定是最小的，看右边的值大小决定是否合并

    //66
    public static int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        for(int i = last; last >= 0; last--){
            if(digits[last] == 9){
                digits[last] = 0;
                continue;
            }
            digits[last] = digits[last] + 1;
            break;
        }
        if(digits[0] == 0){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    //数组初始化出来后都是0    new int[n]

    public static void main(String[] args) {
        merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 9})));
    }
}
