package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class task3_06 {

    //112 DFS
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //没有加这个是因为可能包含节点以及sum值为负数的情况发    targetSum < 0
        if (targetSum < 0 || root == null) return false;
        if (targetSum - root.val == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.right, targetSum - root.val) || hasPathSum(root.left, root.val);
    }

    //BFS
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();
        if (root == null) return false;
        TreeNode temp = root;
        queue.add(temp);
        val.add(targetSum);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            int res = val.poll();
            if (temp.left == null && temp.right == null && temp.val == res) return true;
            if (temp.left != null) {
                queue.add(temp.left);
                val.add(res - temp.val);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                val.add(res - temp.val);
            }
        }
        return false;
    }

    //113 DFS
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(root, targetSum, sub, res);
        return res;
    }

    public void helper(TreeNode node, int targetSum, List<Integer> sub, List<List<Integer>> res) {
        if (node == null) return;
        if (node.left == null && node.right == null && node.val == targetSum) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(sub);
            temp.add(node.val);
            res.add(temp);
            return;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(sub);
        temp.add(node.val);
        helper(node.left, targetSum - node.val, temp, res);
        helper(node.right, targetSum - node.val, temp, res);
    }

    //BFS
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();

        TreeNode temp = root;
        queue.add(temp);
        val.add(targetSum);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int a = 0; a < n; a++) {
                temp = queue.poll();
                sub.add(temp.val);
                if (temp.left == null && temp.right == null && temp.val == val.poll()) {
                    res.add(sub);
                    continue;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                    val.add(targetSum - temp.val);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    val.add(targetSum - temp.val);
                }
                sub.remove(sub.size() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
