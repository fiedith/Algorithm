import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // input row, col
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] graph = new int[row][col];
        
        // input graph info
        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean divided = false;
        int result = 0;
        while(!divided) {
            melt(graph);
            result++;
            int bfsResult = bfs(graph);
            // 0 - cannot be divided
            if(bfsResult == 0) {
                result = 0;
                break;
            // 2 - division occurred
            } else if(bfsResult == 2) {
                divided = true;
            }
        }
        
        System.out.println(result);
    }
    
    private static void melt(int[][] graph) {
        // copy original graph
        int[][] copy = new int[graph.length][graph[0].length];
        for(int i = 0; i < copy.length; i++) {
            System.arraycopy(graph[i], 0, copy[i], 0, graph[i].length);
        }
        
        // d u r l
        int[] dr = new int[]{ 1, -1, 0, 0 };
        int[] dc = new int[]{ 0, 0, 1, -1 };
        
        // O(N * M * 4)
        for(int row = 0; row < copy.length; row++) {
            for(int col = 0; col < copy[0].length; col++) {
                int zeros = 0;
                
                // if current element is not zero, check surroundings
                if(copy[row][col] != 0) {
                    for(int i = 0; i < 4; i++) {
                        int nr = row + dr[i];
                        int nc = col + dc[i];
                        
                        // if out of bounds or not zero, skip
                        if(nr < 0 || nr >= copy.length || nc < 0 || nc >= copy[0].length || copy[nr][nc] != 0) {
                            continue;
                        } else{
                            zeros++;
                        }
                    }
                }
                
                graph[row][col] = (graph[row][col] - zeros < 0) ? 0 : graph[row][col] - zeros;
            }
        }
        
    }
    
    // 0: no divisions, 1: single glacier, 2+: multiple glaciers
    private static int bfs(int[][] graph) {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        
        // queue holding {row, col}
        Deque<int[]> q = new ArrayDeque<>();
        int bfsCount = 0;
        
        int[] dr = new int[]{ 1, -1, 0, 0 };
        int[] dc = new int[]{ 0, 0, 1, -1 };
        
        for(int row = 0; row < graph.length; row++) {
            for(int col = 0; col < graph[0].length; col++) {
                if(visited[row][col]) {
                    continue;
                }
                
                if(graph[row][col] == 0) {
                    visited[row][col] = true;
                } else{
                    bfsCount++;
                    visited[row][col] = true;
                    q.addLast(new int[]{row, col});
                    
                    while(!q.isEmpty()) {
                        int[] pos = q.pollFirst();
                        for(int i = 0; i < 4; i++) {
                            int nr = pos[0] + dr[i];
                            int nc = pos[1] + dc[i];
                            
                            // if out of bounds, zero, or visited -> skip
                            if(nr < 0 || nr >= graph.length || nc < 0 || nc >= graph[0].length || graph[nr][nc] == 0 || visited[nr][nc]) {
                                continue;
                            } else {
                                q.addLast(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                        
                    }
                }
            }
        }
        return (bfsCount >= 2) ? 2 : bfsCount;
    }
}