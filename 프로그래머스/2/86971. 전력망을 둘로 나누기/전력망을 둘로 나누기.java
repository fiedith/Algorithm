import java.util.*;

class Solution {
    private static List<Integer>[] adjList;
    private static boolean[] visited;
    private static int count;   // 한 집합 내 노드 수
    
    public int solution(int n, int[][] wires) {
        adjList = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : wires){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);      // undirected graph
        }
        
        visited = new boolean[n + 1];
        
        // init vals
        count = 0;
        int answer = 987654321;
        
        for(int[] edge : wires){
            // remove one edge & check single set from removed adjList
            adjList[edge[0]].remove(Integer.valueOf(edge[1]));
            adjList[edge[1]].remove(Integer.valueOf(edge[0]));
            dfs(1);
            // count = 한 집합 내 노드수, (n - count) = 반대편 집합 내 노드 수
            answer = Math.min(answer, Math.abs(count - (n - count)));
            
            // revert all for next check
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
            Arrays.fill(visited, false);
            count = 0;
        }
        
        return answer;
    }
    
    private static void dfs(int now){
        visited[now] = true;
        count++;
        for(int next : adjList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}