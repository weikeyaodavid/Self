package leetcode.A_Array;

import java.util.ArrayList;
import java.util.List;

public class task2_12 {

    //54
    public List<Integer> spiralOrder(int[][] matrix) {
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        //matrix[y][x]
        int left = 0;
        int top = 0;
        while(top < bottom && left < right){
            for(int i = left; i < right; i++)res.add(matrix[top][i]);
            for(int i = top; i < bottom; i++)res.add(matrix[i][right]);
            for(int i = right; i > left; i--)res.add(matrix[bottom][i]);
            for(int i = bottom; i > top; i--)res.add(matrix[i][left]);
            top++;
            bottom--;
            left++;
            right--;
        }
        if(left == right){
            for(int i = top; i <= bottom; i++)res.add(matrix[i][left]);
        }else if(top == bottom){
            for(int i = left; i <= right; i++)res.add(matrix[top][i]);
        }
        return res;
    }

    //注意边界值的处理

    //59
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while(left < right && top < bottom){
            for(int a = left; a < right; a++){
                res[top][a] = i;
                i++;
            }
            for(int a = top; a < bottom; a++){
                res[a][right] = i;
                i++;
            }
            for(int a = right; a > left; a--){
                res[bottom][a] = i;
                i++;
            }
            for(int a = bottom; a > top; a--){
                res[a][left] = i;
                i++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if(left == right)res[left][left] = i;
        return res;
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }
}
