package worktest;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode subleft = new TreeNode(4);
        TreeNode subright = new TreeNode(5);
        left.left = subleft;
        left.right = subright;
        root.left = left;
        root.right = right;
        mytree(root);
        List<Integer> a = postOrder(root);
        System.out.println(a);
    }

    public static List<Integer> mytree(TreeNode root) {
        List<Integer> point = new ArrayList<Integer>();
        Getlist(root, point);
        System.out.println(point);
        return point;
    }

    public static void Getlist(TreeNode treeNode, List<Integer> mylist) {
        if (treeNode == null) {
            return;
        }
        Getlist(treeNode.left, mylist);
        Getlist(treeNode.right, mylist);
        mylist.add(treeNode.value);
    }

    public static List<Integer> preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        List<Integer> res = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                res.add(p.value);
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return res;
    }

    public static List<Integer> midorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                res.add(p.value);
                p = p.right;
            }
        }
        return res;
    }

    public static List<Integer> postOrder(TreeNode node) {
        TreeNode root = node;
        TreeNode prev = node;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                //入栈的时候转移为左子节点
                root = root.left;
            }
            if (stack.size() > 0) {
                TreeNode temp = stack.peek().right;//important
                //如果栈顶元素没有右子树或者右子树已经输出过
                //那么栈顶元素没有保存的必要，直接弹出栈顶元素
                if (temp == null || temp == prev) {
                    root = stack.pop();
                    //节点出栈时才输出其信息
                    res.add(root.value);
                    prev = root;
                    root = null;
                } else {
                    //否则右子树没有被访问过，需要访问右子树
                    root = temp;
                }
            }
        }
        return res;
    }

    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
