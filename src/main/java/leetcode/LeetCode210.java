package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/16
 * {@code @description:}
 */
public class LeetCode210 {

    // 建图函数
    List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    /**
     * 拓扑排序，就是记录入度为零的队列中，弹出的每个元素进行记录即可
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 构建入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int to = edge[0], from = edge[1];
            indegree[to]++;
        }
        // 构建入度为0的队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res[count] = poll;
            count++;
            for (Integer to : graph[poll]) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        if (count != numCourses) {
            return new int[]{};
        }
        return res;
    }
}
