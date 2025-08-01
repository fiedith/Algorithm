package ch10;

import java.util.*;

class Test33Answer {
    private static int[] set;

    // find root
    private static int find(int x){
        int parent = set[x];
        // root를 찾을 때까지 호출
        if(set[x] != x){
            parent = find(parent);
        }
        set[x] = parent;     // path compression
        return parent;
    }

    // union -> 두 집합을 하나로 합치기
    private static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        set[rootY] = rootX;
    }

    // n개의 노드가 주어짐 -> 목표는 n-1개의 다리를 놓는 것
    public int solution(int n, int[][] costs) {
        // parent 초기화
        set = new int[n];
        for(int i = 0; i < n; i++){
            set[i] = i;
        }

        // 비용 기준 asc 정렬
        Arrays.sort(costs, (a1, a2) -> Integer.compare(a1[2], a2[2]));

        int answer = 0;
        int edges = 0;  // 다리의 수

        for(int[] edge : costs){
            if(edges == n - 1){
                break;
            }

            // 두 노드가 서로 다른 집합에 속해있는 경우 연결하기 -> MST 구성 시 cycle 형성 방지
            if(find(edge[0]) != find(edge[1])){
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }

        // 최소 비용을 기준으로 오름차순 정렬 했으며 cycle이 발생하지 않는 MST이므로 최적해가 구성됨
        return answer;
    }
}