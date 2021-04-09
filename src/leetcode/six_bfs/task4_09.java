package leetcode.six_bfs;

import leetcode.two_tree.TreeNode;
import java.util.*;

public class task4_09 {

    //103. Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode temp = root;
        queue.add(temp);
        boolean reverse = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subRes = new ArrayList<>();
            for(int i = 0; i < size; i++){
                temp = queue.poll();
                subRes.add(temp.getVal());
                if(temp.getLeft() != null){
                    queue.add(temp.getLeft());
                }
                if(temp.getRight() != null){
                    queue.add(temp.getRight());
                }
            }
            if(reverse){
                Collections.reverse(subRes);
            }
            reverse = !reverse;
            res.add(subRes);
        }
        return res;
    }



    //695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {


    }
}
