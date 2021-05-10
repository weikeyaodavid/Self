package leetcode.two_tree;

import java.util.*;

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

    //114 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.push(temp);
                res.add(temp.val);
                temp = temp.left;
            }
            temp = stack.pop().right;
        }
        return res;
    }


    //94 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;
        }
        return res;
    }


    //145 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> preRes = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            preRes.push(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        while (!preRes.empty()) {
            res.add(preRes.pop());
        }
        return res;
    }


    //102 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp = queue.poll();
                sub.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            res.add(sub);
        }
        return res;
    }
}
