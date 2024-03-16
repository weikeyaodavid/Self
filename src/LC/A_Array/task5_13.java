package LC.A_Array;

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


    // 912. Sort an Array
    // QuickSort 快速排序
    // 不稳定排序 复杂度平均 nlogn
    // 稳定：冒泡排序
    public void quickSort(int[] arr, int start, int end){
        if(start >= end)return;
        int middle = partition(arr, start, end);
        quickSort(arr, start, middle - 1);
        quickSort(arr, middle + 1, end);
    }
    public int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;
        while(left < right){
            while(left < right && arr[left] <= pivot)left++;
            while(left < right && arr[right] >= pivot)right--;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        if(left == right && pivot < arr[right])right--;
        arr[start] = arr[right];
        arr[right] = pivot;
        return right;
    }
}
