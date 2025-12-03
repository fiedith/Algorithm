import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 필수
        StringTokenizer st; // 한 줄에 여러 내용 한꺼번에 입력받을 시 필요
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        
        // for each tcs
        for(int i = 0; i < tc; i++) {
            int shopCount = Integer.parseInt(br.readLine());
            int[][] nodes = new int[shopCount + 2][2];    // includes src, shops, dest
            boolean[] visited = new boolean[shopCount + 2];    // includes src, shops, dest
            
            // src pos input (nodes[0] = src)
            st = new StringTokenizer(br.readLine());
            nodes[0][0] = Integer.parseInt(st.nextToken());
            nodes[0][1] = Integer.parseInt(st.nextToken());
            
            // shops pos input
            for(int j = 0; j < shopCount; j++) {
                st = new StringTokenizer(br.readLine());
                nodes[j + 1][0] = Integer.parseInt(st.nextToken());
                nodes[j + 1][1] = Integer.parseInt(st.nextToken());
            }
            
            // dest pos input (nodes[last] = dest)
            st = new StringTokenizer(br.readLine());
            nodes[nodes.length - 1][0] = Integer.parseInt(st.nextToken());
            nodes[nodes.length - 1][1] = Integer.parseInt(st.nextToken());
            
            // 
            if(bfs(visited, nodes, 0)) {
                sb.append("happy\n");
            } else{
                sb.append("sad\n");
            }
        }
        
        System.out.println(sb.toString());
    }
    
    private static boolean bfs(boolean[] visited, int[][] nodes, int idx) {
        final int destPos = nodes.length - 1;    // dest node pos
        
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(idx);
        
        while(!q.isEmpty()) {
            int currentPos = q.pollFirst();
            // if polled node is dest, return true
            if(currentPos == destPos) {
                return true;
            }
            
            // if not visited and reachable, add idx
            for(int i = 0; i <= destPos; i++) {
                if(!visited[i] && isReachable(nodes[currentPos], nodes[i])) {
                    q.addLast(i);
                    visited[i] = true;
                }
            }
        }
        
        // if true not returned within loop, return false
        return false;
    }
    
    
    private static boolean isReachable(int[] src, int[] dest) {
        return (Math.abs(src[0] - dest[0]) + Math.abs(src[1] - dest[1])) <= 1000;
    }
}