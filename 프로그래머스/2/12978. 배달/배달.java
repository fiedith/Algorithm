import java.util.*;

class Solution {
    private static class Node{
        int number, cost;
        public Node(int number, int cost){
            this.number = number;
            this.cost = cost;
        }
    }
    
    private static final int INF = 987654321;
    
    public int solution(int N, int[][] road, int K) {
        // distance
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;
        
        // adjacency list
        List<Node>[] adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : road){
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));   // undirected graph
        }
        
        // visited
        boolean[] visited = new boolean[N + 1];
        
        // priority queue for shortest path
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.number]){
                continue;
            }
            
            visited[now.number] = true;
            for(Node next : adjList[now.number]){
                if(now.cost + next.cost < distance[next.number]){
                    distance[next.number] = now.cost + next.cost;
                    pq.add(new Node(next.number, distance[next.number]));
                }
            }
        }
        
        int answer = 0;
        for(int dist : distance){
            if(dist <= K){
                answer++;
            }
        }
        
        return answer;
    }
}