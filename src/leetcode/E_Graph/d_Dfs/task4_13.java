package leetcode.E_Graph.d_Dfs;

import leetcode.D_Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class task4_13 {

    //797. All Paths From Source to Target
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        dfsAllPath(res, new ArrayList<>(), graph, stack);
        return res;
    }

    private void dfsAllPath(List<List<Integer>> res, ArrayList<Integer> objects, int[][] graph, LinkedList<Integer> stack) {
        if(stack.isEmpty())return;
        int target = stack.pop();
        objects.add(target);
        if(target == graph.length - 1){
            res.add(new ArrayList<>(objects));
            return;
        }
        for(int i = 0; i < graph[target].length; i++){
            stack.push(graph[target][i]);
            dfsAllPath(res, new ArrayList<>(objects), graph, stack);
        }
    }

    //129. Sum Root to Leaf Numbers
    ArrayList<Integer> res = new ArrayList<>();
    ArrayList<Integer> num = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        TreeNode temp = root;
        dfs(temp);
        int sum = 0;
        for(int i : res){
            sum = sum + i;
        }
        return sum;
    }
    public void dfs(TreeNode node){
        if(node.getLeft() == null && node.getRight() == null){
            num.add(node.getVal());
            String s = "";
            for(int i : num){
                s = s + i;
            }
            res.add(Integer.valueOf(s));
            return;
        }
        num.add(node.getVal());
        if(node.getLeft() != null){
            dfs(node.getLeft());
            num.remove(num.size() - 1);
        }
        if(node.getRight() != null){
            dfs(node.getRight());
            num.remove(num.size() - 1);
        }
    }

    //improve
    //先分成小问题，左边和加右边和
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.getVal();
        if (root.getLeft() == null && root.getRight() == null)
            return temp;
        return helper(root.getLeft(), temp) + helper(root.getRight(), temp);
    }

}
