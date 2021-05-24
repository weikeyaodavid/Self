package leetcode.B_Tree;

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
}
