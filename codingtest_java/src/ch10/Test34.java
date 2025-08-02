package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test34 {

    private static List<Integer>[] adjList;
    private static boolean[] visited;
    private static List<Integer> answer;

    public static List<Integer> solution(List<int[]> graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] arr : graph) {
            adjList[arr[0]].add(arr[1]);
        }

        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);
        return answer;
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        List<int[]> graph = new ArrayList<>(Arrays.asList(
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 5}
        ));

        List<Integer> result = solution(graph, 1, 5);
        System.out.println(result);
    }
}
