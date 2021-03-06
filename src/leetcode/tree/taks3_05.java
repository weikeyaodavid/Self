package leetcode.tree;

import java.util.*;

public class taks3_05 {

    //114
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !stack.empty()){
            while(temp != null){
                stack.push(temp);
                res.add(temp.val);
                temp = temp.left;
            }
            temp = stack.pop().right;
        }
        return res;
    }


    //94
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !stack.empty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;
        }
        return res;
    }


    //145
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> preRes = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if(root == null)return new ArrayList<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            preRes.push(temp.val);
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
        while(!preRes.empty()){
            res.add(preRes.pop());
        }
        return res;
    }


    //102
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode temp = root;
        queue.add(temp);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> sub = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp = queue.poll();
                sub.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(sub);
        }
        return res;
    }


    //104
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max + 1;
    }

    //111    BFS
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null)return 0;
        TreeNode temp = root;
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            level++;
            for(int i = 0; i < n; i++){
                temp = queue.poll();
                if(temp.left == null && temp.right == null)return level;
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return level;
    }
    //DFS
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;
        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }


    //101 递归
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public static boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null)return true;
        if(left == null || right == null)return false;
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
    //迭代
    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null)continue;
            if(left == null || right == null)return false;
            if(left.val != right.val)return false;
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
        }
        return true;
    }

    //递归法转迭代法就是需要用队列queue


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        isSymmetric(root);
    }
}





