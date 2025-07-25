package ch09;

import java.util.*;

class Test29Answer {

    private static class Info {
        int node, sheep, wolf;
        Set<Integer> adjacent;

        public Info(int node, int sheep, int wolf, Set<Integer> adjacent) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.adjacent = adjacent;
        }
    }

    // list를 담는 배열 -> 인접 리스트로 트리 표현
    private static List<Integer>[] tree;

    private static void buildTree(int[] info, int[][] edges) {
        // 트리 배열 초기화
        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    public static int solution(int[] info, int[][] edges) {
        buildTree(info, edges);
        int answer = 0;

        Deque<Info> q = new ArrayDeque<>();     // BFS queue
        q.add(new Info(0, 1, 0, new HashSet<>()));

        while (!q.isEmpty()) {
            Info now = q.pollFirst();
            answer = Math.max(answer, now.sheep);
            now.adjacent.addAll(tree[now.node]);    // 현재 노드에 인접한 모든 노드 추가

            // 모든 인접 노드에 대해 방문함
            for (int next : now.adjacent) {
                Set<Integer> set = new HashSet<>(now.adjacent);     // 기존 인접 노드 데이터 복사
                set.remove(next);

                if (info[next] == 1) {
                    if (now.sheep != now.wolf + 1) {
                        q.addLast(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    q.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6},
                {8, 9}
        };

        System.out.println(solution(info, edges));
    }
}