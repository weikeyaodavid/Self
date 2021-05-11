package leetcode.three_backTracking;

public class Documents {

//    使用回溯法的明显标志
//            1. 排列、组合（子集、幂集、字符全排列）。 在传值时，对于排列问题，是要删掉单个用过的元素；组合问题，是删掉前面所有的元素。
//            2. 数组、字符串，给定一个特定的规则，尝试搜索迭代找到某个解。
//            3. 二维数组下的DFS搜索（八皇后、黄金矿工、数独）
//            4. 切割，子集，棋盘



    //回溯全排列还是不包含相同排列
    //全排列
    // for(int i = 0; i < nums.length; i++){
    //
    //不包含相同排列
    // for(int i = startIndex; i < nums.length; i++){


    //经典回溯去重方法
    //在一个数组中包含相同元素的去重复组合方法
    // if(used[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0))continue;



//    代码框架      根据情况决定是否使用used[i]
//
//    result = []
//    def backtrack(路径, 选择列表):
//        if 满足结束条件:
//            result.add(路径)
//            return
//
//        for 选择 in 选择列表:
//            做选择
//            backtrack(路径, 选择列表)
//            撤销选择

}