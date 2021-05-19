package leetcode.K_TopologicalSort;

import java.util.*;

public class task4_12 {

    //207. Course Schedule
    //拓扑排序
    //用有向图描述依赖关系   把一个 有向无环图 转成 线性的排序 就叫 拓扑排序
    //如果存在一条有向边 A --> B，则这条边给 A 增加了 1 个出度，给 B 增加了 1 个入度。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> dependence = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            inDegree.put(i, 0);
        }
        for (int[] prerequisite : prerequisites) {
            inDegree.put(prerequisite[0], inDegree.get(prerequisite[0]) + 1);
            if (!dependence.containsKey(prerequisite[1])) {
                dependence.put(prerequisite[1], new ArrayList<>());
            }
            dependence.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i = 0; i < inDegree.size(); i++){
            if(inDegree.get(i) == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int zero = queue.poll();
            if(!dependence.containsKey(zero))continue;
            List<Integer> deduct = dependence.get(zero);
            for (Integer integer : deduct) {
                inDegree.put(integer, inDegree.get(integer) - 1);
                if (inDegree.get(integer) == 0) queue.add(integer);
            }
        }
        for(int key : inDegree.keySet()){
            if(inDegree.get(key) != 0){
                return false;
            }
        }
        return true;
    }
}
