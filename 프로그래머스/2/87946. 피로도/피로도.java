import java.util.*;

class Solution {
    private static int n;
    private static boolean[] visited;
    private static int[][] data;
    private static int result;
    
    public static int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        data = dungeons;
        result = 0;
        
        dfs(k, 0);
        return result;
    }
    
    // 피로도, depth
    private static void dfs(int k, int depth){
        // 위에서 통과했으며 최대 깊이로 주어진 경우
        if(depth == n){
            result = n;
            return;
        }
        
        result = Math.max(result, depth);
        
        for(int i = 0; i < n; i++){
            // 방문을 안했으며 최소 피로도 만족시 진입
            if(!visited[i] && k >= data[i][0]){
                visited[i] = true;
                dfs(k - data[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}