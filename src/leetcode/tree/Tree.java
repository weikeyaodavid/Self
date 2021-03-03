package leetcode.tree;

import java.util.Stack;

public class Tree {
    TreeNode root;

    //一般在生活中使用二叉搜索树（BST - Binary Search Tree）
    //       左子树 < 根 < 右子树

    //二叉搜索树的插入方法
    public void insert(Tree tree, int val) {
        TreeNode node = new TreeNode(val);
        node.left = null;
        node.right = null;

        //若为空树则直接变成根节点
        if (tree.root == null){
            tree.root = node;
            return;
        }

        //创建临时节点方便判断  相当于两个头一个身体
        TreeNode temp = tree.root;
        while (temp != null) {
            if (temp.val > val) {
                if (temp.left == null) {
                    temp.left = node;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return;
                }
                temp = temp.right;
            }
        }
    }
}