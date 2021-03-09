package leetcode.tree;

import java.util.*;

public class task3_09 {

    //116 层序遍历
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


    //236
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        
        return null;
    }

}
