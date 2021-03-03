package leetcode.tree;

import java.util.Stack;

public class Tree {
    TreeNode root;

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
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return;
                } else {
                    temp = temp.right;
                }
            }
        }
    }



    //非递归遍历方法

    public void preorder(TreeNode node){
        TreeNode temp = node;
        Stack<TreeNode> stack = new Stack<>();
        while(temp != null || !stack.empty()){
            while(temp != null){
                System.out.println(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop().right;
        }
    }

    public void inorder(TreeNode node){
        TreeNode temp = node;
        Stack<TreeNode> stack = new Stack<>();
        while(temp != null || !stack.empty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.println(temp.val);
            temp = temp.right;
        }
    }

    public void postorder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> res = new Stack<>();
        if(root == null)return;
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            res.push(temp.val);
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
        while(!res.empty()){
            System.out.println(res.pop());
        }
    }
}


//一般在生活中使用二叉搜索树（BST - Binary Search Tree）
//       左子树 < 根 < 右子树