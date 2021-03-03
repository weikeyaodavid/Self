package leetcode.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void preorder(TreeNode node){
        if(node != null){
            System.out.println(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(TreeNode node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.val);
            inorder(node.right);
        }
    }

    public void postorder(TreeNode node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.val);
        }
    }

    //得到当前树（普通树）最大深度  找到左右子树最大的层数
    public int getHeight(TreeNode node){
        if(node == null)return 0;

        int leftTree = getHeight(node.left);
        int rightTree = getHeight(node.right);
        int max = Math.max(leftTree, rightTree);
        return max + 1;
    }

    //得到当前树（普通树）最大节点  找到左右子树和本节点的最大值
    public int getMaxVal(TreeNode node){
        if(node == null)return -1;

        int rootTree = node.val;
        int leftTree = getMaxVal(node.left);
        int rightTree = getMaxVal(node.right);
        int max = Math.max(leftTree, rightTree);
        max = Math.max(max, rootTree);

        return max;
    }
}