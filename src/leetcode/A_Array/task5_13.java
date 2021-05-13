package leetcode.A_Array;

public class task5_13 {

    //69. Sqrt(x)
    //int 会存不住 a * a（太大了）， 用 long
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left <= right){
            long mid = (left + right) / 2;
            if(mid * mid > x) {
                right = mid - 1;
            }else if(mid * mid < x){
                left = mid + 1;
            }else {
                return (int)mid;
            }
        }
        return left * left > x ? (int)left - 1 : (int)left;
    }
}
