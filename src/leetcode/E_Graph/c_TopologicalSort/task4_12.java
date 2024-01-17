package leetcode.E_Graph.c_TopologicalSort;

import java.util.*;

public class task4_12 {

    //207. Course Schedule
    //拓扑排序
    //用有向图描述依赖关系   把一个 有向无环图 转成 线性的排序 就叫 拓扑排序
    //如果存在一条有向边 A --> B，则这条边给 A 增加了 1 个出度，给 B 增加了 1 个入度。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 建立邻接表（依赖关系）
        Set<Integer>[] graph = new HashSet[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new HashSet<>();
        }

        // 2. 建立度数组（依赖个数）
        int[] degree = new int[numCourses];

        // 3. 初始化邻接表（哪些课依赖当前课学完才能学的list）初始化度数组（当前课依赖几门课）
        for(int[] relation : prerequisites){
            graph[relation[1]].add(relation[0]);
            degree[relation[0]]++;
        }

        // 4. 把当前无任何依赖的课加入队列中
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }

        // 5. 取出无依赖的课，把所有依赖他的课的度 - 1，把 - 1后无任何依赖的课再次加入队列，开始循环
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer course = queue.poll();
                graph[course].forEach(set -> {
                    degree[set]--;
                    if(degree[set] == 0){
                        queue.offer(set);
                    }
                });
            }
        }

        // 6. 判断是否还有课程未被学习（图是否有环 - 循环依赖）
        for(int i = 0; i < numCourses; i++){
            if(degree[i] != 0){
                return false;
            }
        }
        return true;
    }

    // 210. Course Schedule II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new HashSet[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new HashSet<>();
        }

        int[] degree = new int[numCourses];

        for(int[] relation : prerequisites){
            graph[relation[1]].add(relation[0]);
            degree[relation[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer course = queue.poll();
                graph[course].forEach(set -> {
                    degree[set]--;
                    if(degree[set] == 0){
                        queue.offer(set);
                    }
                    res.add(set);
                });
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(degree[i] != 0){
                return new int[]{};
            }
        }
        int[] resArray = new int[numCourses];
        for(int i = 0; i < resArray.length; i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
