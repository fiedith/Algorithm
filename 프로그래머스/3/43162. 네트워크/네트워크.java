import java.util.*;

class Solution {
    
    private static List<Integer>[] adjList;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++){
            int[] edge = computers[i];
            for(int j = 0; j < edge.length; j++){
                if(edge[j] == 1 && i != j){
                    adjList[i].add(j);
                }
            }
        }
        
        visited = new boolean[n];
        
        int answer = 0;
        
        // call dfs for all nodes
        // count all unvisited dfs calls and return as answer
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    // recursively visit all adjacent nodes and mark as visited
    private static void dfs(int x){
        visited[x] = true;
        if(adjList[x].isEmpty()){
            return;
        }
        for(int next : adjList[x]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}