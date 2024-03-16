package LC.D_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class task5_24 {

    //297. Serialize and Deserialize Binary Tree
    public String serialize(TreeNode root) {
        if(root == null)return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    public String preOrder(TreeNode root) {
        if(root == null)return "";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    public TreeNode deserialize(String data) {
        String[] source = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(source));
        return buildTree(queue);
    }
    public TreeNode buildTree(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("X")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }

    //124. Binary Tree Maximum Path Sum
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int leftMax = Math.max(0, dfs(root.left));
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightMax = Math.max(0, dfs(root.right));
        //left->root->right 作为路径与已经计算过历史最大值做比较
        max = Math.max(max, root.val + leftMax + rightMax);
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return root.val + Math.max(leftMax, rightMax);
    }
}
