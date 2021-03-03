package leetcode.tree;

public class task3_03 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 8, 2, 5, 1, 7};
        Tree tree = new Tree();
        tree.root = null;
        for (int i = 0; i < 7; i++) {
            tree.insert(tree, arr[i]);
        }

        tree.postorder(tree.root);
        tree.root.postorder(tree.root);
        //所有二叉搜索树的中序遍历都是从小到大排列
        //tree.root.inorder(tree.root);        //1，2，3，5，6，7，8
        //System.out.println(tree.root.getHeight(tree.root));
        //System.out.println(tree.root.getMaxVal(tree.root));
    }
}
