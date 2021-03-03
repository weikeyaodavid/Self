package leetcode.array;

public class task2_05 {

    //48
    public void rotate(int[][] matrix) {
        //上下翻转
        for(int i = 0; i < matrix.length / 2; i++){
            int [] temp = matrix[i];
            matrix[i] = matrix[matrix.length - i -1];
            matrix[matrix.length - i -1] = temp;
        }
        //对角线翻转
        for(int i = 0; i < matrix.length; i++){
            for(int x = 0; x < matrix[0].length; x++){
                int tmp = matrix[i][x];
                matrix[i][x] = matrix[x][i];
                matrix[x][i] = tmp;
            }
        }
    }

    //抓住关键等式，通过规律找出交换方程式，再应用到所有
    //matrix[x][y] = matrix[y][matrix.length - x - 1];

    //沿对角线旋转方法
    //for (int i = 0; i < n; i ++){
    //  for (int j= i + 1; j < n; j++){
    public static void main(String[] args) {

    }
}

//  [1,2,3]        [7,4,1]
//  [4,5,6]        [8,5,2]
//  [7,8,9]        [9,6,3]

//  00 02
//  01 12
//  02 22

//  10 01
//  11 11
//  12 21

//  20 00
//  21 10
//  22 20

