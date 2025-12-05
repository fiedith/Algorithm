import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        
        int[][][] graph = new int[height][row][col];
        boolean[][][] visited = new boolean[height][row][col];
        
        /* {height, row, col, value} */
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < col; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    // if ripe, directly add to queue and mark visited
                    if(graph[i][j][k] == 1) {
                        q.addLast(new int[]{i, j, k, 0});
                        visited[i][j][k] = true;
                    }
                    
                    // if empty space, mark visited
                    if(graph[i][j][k] == -1) {
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        
        int result = 0;
        
        /* d u r l */
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};
        
        /* start bfs */
        while(!q.isEmpty()) {
            int[] info = q.pollFirst();
            int curHeight = info[0];
            int curRow = info[1];
            int curCol = info[2];
            int curVal = info[3];
            
            result = Math.max(result, curVal);
            
            /* check lower height */
            if(curHeight - 1 >= 0 && !visited[curHeight - 1][curRow][curCol]) {
                visited[curHeight - 1][curRow][curCol] = true;
                q.add(new int[]{curHeight - 1, curRow, curCol, curVal + 1});
            }
            
            /* check upper height */
            if(curHeight + 1 < height && !visited[curHeight + 1][curRow][curCol]) {
                visited[curHeight + 1][curRow][curCol] = true;
                q.add(new int[]{curHeight + 1, curRow, curCol, curVal + 1});
            }
            
            /* d u r l in current height */
            for(int i = 0; i < 4; i++) {
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];
                
                // skip if out of bounds or visited
                if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[curHeight][nr][nc]) {
                    continue;
                }
                
                // else, mark visited and add to queue
                q.addLast(new int[]{curHeight, nr, nc, curVal + 1});
                visited[curHeight][nr][nc] = true;
            }
        }
        
        // upon bfs termination, check if all spaces are visited
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    if(!visited[i][j][k]) {
                        // if not yet visited space exists, set result as -1 and quit loop
                        result = -1;
                        // force quit loops
                        k = col - 1;
                        j = row - 1;
                        i = height - 1;
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}