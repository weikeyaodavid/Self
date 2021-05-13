package leetcode.B_Tree;

import worktest.ListNode;

import java.util.*;

public class task3_09 {

    //116
    //层序遍历
    public TreeNode connect(TreeNode root) {
        if(root == null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                temp = queue.poll();
//                if(i == n - 1)temp.next = null;
//                else temp.next = queue.peek();
                if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
            }
        }
        return root;
    }


    //117
    public TreeNode connect2(TreeNode root) {
        if(root == null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                temp = queue.poll();
//                if(i == n - 1)temp.next = null;
//                else temp.next = queue.peek();
                if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
            }
        }
        return root;
    }


    //236 Lowest Common Ancestor of a Binary Tree
    //好难想  最近公共祖先就是找指定的两个节点是否在一个点的两侧或者一侧，一侧则是p/q，两侧则是当前节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null)return right;
        if(right == null)return left;
        return root;
    }


    //235
    //可重用236方法   也可以遍历一次找出当前节点值在pq中间的点，即为最小公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        while(true){
            if(temp.val > p.val && temp.val > q.val){
                temp = temp.left;
            }else if(temp.val < p.val && temp.val < q.val){
                temp = temp.right;
            }else{
                break;
            }
        }
        return temp;
    }


    //98 Validate Binary Search Tree
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


    //100 Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q && p == null)return true;
        if(p == null || q == null)return false;
        if(p.val != q.val)return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    //110 Balanced Binary Tree
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1) res = false;
        return Math.max(left, right);
    }


    //226 Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null)invertTree(root.left);
        if(root.right != null)invertTree(root.right);
        return root;
    }
}
