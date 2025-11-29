import java.util.*;

class Solution {
    private List<Integer>[] adjList;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        // init adjacency list, visited arr
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        visited = new boolean[n];
        
        // fill in adj list
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1 && i != j) {
                    adjList[i].add(j);
                }
            }
        }
        
        int result = 0;
        
        // for each nodes
        for(int i = 0; i < n; i++) {
            // if current node not visited, run dfs
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        
        return result;
    }
    
    // marks current node & all connected nodes as visited
    private void dfs(int node) {
        // mark current node as visited
        visited[node] = true;
        
        // get all connected nodes
        List<Integer> connected = adjList[node];
        
        // for each connected nodes, run dfs
        for(int next : connected) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}