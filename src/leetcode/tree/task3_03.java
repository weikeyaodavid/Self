package leetcode.tree;

import java.util.Stack;

public class task3_03 {

    public void preorder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }

    //所有二叉搜索树的中序遍历都是从小到大排列
    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.val);
            inorder(node.right);
        }
    }

    public void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.val);
        }
    }

    //非递归遍历方法
    public void preorder2(TreeNode node) {
        TreeNode temp = node;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.empty()) {
            while (temp != null) {
                System.out.println(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop().right;
        }
    }

    //所有二叉搜索树的中序遍历都是从小到大排列
    public void inorder2(TreeNode node) {
        TreeNode temp = node;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.println(temp.val);
            temp = temp.right;
        }
    }

    public void postorder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> res = new Stack<>();
        if (node == null) return;
        stack.push(node);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            res.push(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        while (!res.empty()) {
            System.out.println(res.pop());
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 8, 2, 5, 1, 7};
        Tree tree = new Tree();
        tree.root = null;
        for (int i = 0; i < 7; i++) {
            tree.insert(tree, arr[i]);
        }
        //inorder(tree.root);        //1，2，3，5，6，7，8
        System.out.println(tree.root.getHeight(tree.root));
        System.out.println(tree.root.getMaxVal(tree.root));
    }
}
