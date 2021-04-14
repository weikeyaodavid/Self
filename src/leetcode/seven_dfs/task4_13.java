package leetcode.seven_dfs;

import leetcode.two_tree.TreeNode;

import java.util.ArrayList;

public class task4_13 {

    //129. Sum Root to Leaf Numbers
    ArrayList<Integer> res = new ArrayList<>();
    ArrayList<Integer> num = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        TreeNode temp = root;
        dfs(temp);
        int sum = 0;
        for(int i : res){
            sum = sum + i;
        }
        return sum;
    }
    public void dfs(TreeNode node){
        if(node.getLeft() == null && node.getRight() == null){
            num.add(node.getVal());
            String s = "";
            for(int i : num){
                s = s + i;
            }
            res.add(Integer.valueOf(s));
            return;
        }
        num.add(node.getVal());
        if(node.getLeft() != null){
            dfs(node.getLeft());
            num.remove(num.size() - 1);
        }
        if(node.getRight() != null){
            dfs(node.getRight());
            num.remove(num.size() - 1);
        }
    }

    //improve
    //先分成小问题，左边和加右边和
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.getVal();
        if (root.getLeft() == null && root.getRight() == null)
            return temp;
        return helper(root.getLeft(), temp) + helper(root.getRight(), temp);
    }




}
