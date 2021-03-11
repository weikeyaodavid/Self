package leetcode.tree;

import java.util.Arrays;
import java.util.HashMap;

public class task3_07 {

    //106 后序遍历的末尾值为根节点 中序遍历的根节点左边为左子树，右边为右子树
    HashMap<Integer, Integer> memory = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //此操作是为了在另一个方法中可用数组，不需要将数组传进去
        post = postorder;
        for (int i = 0; i < inorder.length; i++) memory.put(inorder[i], i);
        TreeNode root = buildTree(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }
    private TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        int root = post[pe];
        TreeNode node = new TreeNode(root);
        int rootIndex = memory.get(root);
        node.left = buildTree(is, rootIndex - 1, ps, ps + rootIndex - 1 - is);
        node.right = buildTree(rootIndex + 1, ie, ps + rootIndex - is, pe - 1);
        return node;
    }


    //105  与106类似 先序遍历根节点在第一个
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] pre;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) memo.put(inorder[i], i);
        TreeNode node = buildTree2(0, preorder.length - 1, 0, inorder.length - 1);
        return node;
    }
    public TreeNode buildTree2(int pl, int pr, int il, int ir) {
        if(pl > pr || il > ir)return null;
        int rootVal = pre[pl];
        int rootIndex = memo.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree2(pl + 1, rootIndex - il + pl, il, rootIndex - 1);
        root.right = buildTree2(rootIndex - il + pl + 1, pr, rootIndex + 1, ir);
        return root;
    }


    //889 先序遍历的第二个节点为左子树的根节点，后序遍历左子树的根节点为左子树的最后一个元素
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if(n == 0)return null;
        TreeNode root = new TreeNode(pre[0]);
        if(n == 1)return root;
        int N = 0;
        for(int i = 0; i < n; i++){
            if(pre[1] == post[i])
                N = i + 1;
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, N + 1), Arrays.copyOfRange(post, 0, N));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, N + 1, n), Arrays.copyOfRange(post, N, n - 1));
        return root;
    }
}
