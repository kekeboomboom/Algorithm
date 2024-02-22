package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/12
 * {@code @description:}
 */
public class TraverseDFS {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle=false;

    /**
     * 这个是判断是否有环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    void traverse(List<Integer>[] graph, int curCourse) {
        if (onPath[curCourse]) {
            hasCycle = true;
        }
        if (visited[curCourse] || hasCycle) {
            return;
        }
        visited[curCourse] = true;
        onPath[curCourse] = true;
        for (Integer i : graph[curCourse]) {
            traverse(graph, i);
        }
        onPath[curCourse] = false;
    }

    /**
     * 构建邻接表. 对于当前prerequisites在题目中的含义，来确定edge from to
     * @param numCourses
     * @param prerequisites
     * @return
     */
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 添加一条从 from 指向 to 的有向边
            // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
            graph[from].add(to);
        }
        return graph;
    }


    List<Integer> res;
    /**
     * 这个先判断是否有环，没有环的话返回拓扑排序。使用dfs拓扑排序，方法是后序遍历后，对结果在进行反转即可
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        res = new ArrayList<>(numCourses);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse2(graph, i);
        }
        if (hasCycle) {
            return new int[]{};
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    void traverse2(List<Integer>[] graph, int curCourse) {
        if (onPath[curCourse]) {
            hasCycle = true;
        }
        if (visited[curCourse] || hasCycle) {
            return;
        }
        visited[curCourse] = true;
        onPath[curCourse] = true;
        for (Integer i : graph[curCourse]) {
            traverse2(graph, i);
        }
        onPath[curCourse] = false;
        res.add(curCourse);
    }
}
