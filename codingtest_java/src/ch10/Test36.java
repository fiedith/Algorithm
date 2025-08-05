package ch10;

import java.util.*;

class Test36 {

    private static final int INF = 987654321;

    private static class Node{
        int number, cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        List<Node>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        // 항상 비용이 낮은 노드부터 poll하는 queue
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 이미 방문된 노드면 poll후 바로 다음 노드로 넘어가기
            if (visited[now.number]) {
                continue;
            }
            visited[now.number] = true;

            // 연결된 다음 노드들의 최소 거리값을 갱신하기 위한 과정
            for (Node next : adjList[now.number]) {
                if (!visited[next.number] && distance[next.number] > now.cost + next.cost) {
                    distance[next.number] = now.cost + next.cost;
                    pq.add(new Node(next.number, distance[next.number]));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 4},  // 0 -> 1 with cost 4
                {0, 2, 1},  // 0 -> 2 with cost 1
                {2, 1, 1}   // 2 -> 1 with cost 1
        };
        int start = 0;
        int n = 3;

//        int[] result = solution(graph2, 0, 4);
        int[] result = solution(graph, start, n);
        System.out.println(Arrays.toString(result));
    }
}
