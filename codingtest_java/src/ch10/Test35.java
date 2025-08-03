package ch10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Test35 {

    private static List<Integer> answer;
    private static List<Integer>[] adjList;
    private static boolean[] visited;

    public static List<Integer> solution(List<int[]> graph, int start, int n) {
        answer = new ArrayList<>();
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }
        visited = new boolean[n + 1];

        bfs(start);
        return answer;
    }

    public static void bfs(int start) {
        // init q
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.pollFirst();
            answer.add(now);
            for (int next : adjList[now]) {
                if (!visited[next]) {
                    q.addLast(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<int[]> graph = Arrays.asList(
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 4},
                new int[]{2, 5},
                new int[]{3, 6},
                new int[]{3, 7},
                new int[]{4, 8},
                new int[]{5, 8},
                new int[]{6, 9},
                new int[]{7, 9}
        );

        solution(graph, 1, 9);
        System.out.println(answer);
    }

}
