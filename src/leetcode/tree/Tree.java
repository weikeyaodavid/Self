package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    TreeNode root;

    //一般在生活中使用二叉搜索树（BST - Binary Search Tree）
    //       左子树 < 根 < 右子树

    //二叉搜索树的插入方法
    public void insert(Tree tree, int val) {
        TreeNode node = new TreeNode(val);
        node.left = null;
        node.right = null;

        //若为空树则直接变成根节点
        if (tree.root == null){
            tree.root = node;
            return;
        }

        //创建临时节点方便判断  相当于两个头一个身体
        TreeNode temp = tree.root;
        while (temp != null) {
            if (temp.val > val) {
                if (temp.left == null) {
                    temp.left = node;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return;
                }
                temp = temp.right;
            }
        }
    }

//    只是比较两段代码的话，最直观的感受就是：DFS 遍历的代码比 BFS 简洁太多了！
//    这是因为递归的方式隐含地使用了系统的 栈，我们不需要自己维护一个数据结构。
//    如果只是简单地将二叉树遍历一遍，那么 DFS 显然是更方便的选择。

//    BFS用来解决层序遍历和最短路径问题

    //DFS遍历使用递归
    public void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

    //BFS遍历使用队列
    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


//    如果不需要确定当前遍历到了哪一层，BFS模板如下。
//
//            while queue 不空：
//              cur = queue.pop()
//              for 节点 in cur的所有相邻节点：
//                  if 该节点有效且未访问过：
//                      queue.push(该节点)
//
//    如果要确定当前遍历到了哪一层，BFS模板如下。
//    这里增加了level表示当前遍历到二叉树中的哪一层了，也可以理解为在一个图中，现在已经走了多少步了。size表示在当前遍历层有多少个元素，也就是队列中的元素数，我们把这些元素一次性遍历完，即把当前层的所有元素都向外走了一步。
//
//            level = 0
//            while queue 不空：
//              size = queue.size()
//              while (size --) {
//                  cur = queue.pop()
//                  for 节点 in cur的所有相邻节点：
//                      if 该节点有效且未被访问过：
//                          queue.push(该节点)
//              }
//              level ++;


}