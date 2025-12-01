import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());
        int[][] graph = new int[size][size];
        boolean[][] visited = new boolean[size][size];
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
            String row = br.readLine();
            String[] splitted = row.split("");
            for(int j = 0; j < splitted.length; j++) {
                graph[i][j] = Integer.parseInt(splitted[j]);
            }
        }
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                // skip visited elements
                if(visited[i][j]) {
                    continue;
                // mark 0s as visited and continue
                } else if(graph[i][j] == 0) {
                    visited[i][j] = true;
                // else, start bfs
                } else {
                    result.add(bfs(graph, visited, i, j));
                }
            }
        }
        
        Collections.sort(result);
        
        // console print optimization
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        
        for(int num : result) {
            sb.append(num).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static int bfs(int[][] graph, boolean[][] visited, int row, int col) {
        Deque<int[]> q = new ArrayDeque<>();
        int counter = 1;    // init counter
        int size = graph[0].length;
        
        visited[row][col] = true;
        q.addLast(new int[]{row, col});
        
        // d u r l
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};
        
        while(!q.isEmpty()) {
            int[] polled = q.pollFirst();
            int pr = polled[0];    // polled row
            int pc = polled[1];    // polled col
            
            // get next pos in d u r l order
            for(int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                
                // if out of bounds or visited
                if(nr < 0 || nr >= size || nc < 0 || nc >= size || visited[nr][nc]) {
                    continue;
                } else if(graph[nr][nc] == 0) {
                    visited[nr][nc] = true;
                } else{
                    visited[nr][nc] = true;
                    q.addLast(new int[]{nr, nc});
                    counter++;
                }
            }
        }
        
        return counter;
    }
}