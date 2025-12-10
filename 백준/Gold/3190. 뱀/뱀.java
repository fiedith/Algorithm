import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // D: clockwise, L: counterclockwise (d or else)
        final String CLOCKWISE = "D";
        final int APPLE = 1;
        final int EMPTY = 0;
        final int SNAKE = -1;
        
        // starting from right to clockwise dir
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        
        /* input graph */
        int graphSize = Integer.parseInt(br.readLine());
        int[][] graph = new int[graphSize][graphSize];
        graph[0][0] = SNAKE;
        
        /* input apples */
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            // 1-based input
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            graph[r][c] = APPLE;
        }
        
        /* input commands */
        int l = Integer.parseInt(br.readLine());
        Map<Integer, Integer> commandMap = new HashMap<>();    // <time, dir(-1, 1))>
        
        for(int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            if(dir.equals(CLOCKWISE)) {
                commandMap.put(time, 1);
            } else {
                commandMap.put(time, -1);
            }
        }
        
        int totalTime = 0;    // timer counter(result)
        int dir = 0;    // direction
        int row = 0;    // head row pos
        int col = 0;    // head col pos
        
        // queue to keep positions
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        
        /* start simulation */
        while(true) {
            
            /* 1) increase timer first */
            totalTime++;
            int nr = row + dr[dir];
            int nc = col + dc[dir];
            
            /* 2) attempt move, if next move is wall or snake, assume the snake moved (totalTime++) and return */
            if(nr < 0 || nr >= graphSize || nc < 0 || nc >= graphSize || graph[nr][nc] == SNAKE) {
                break;
            }
            
            // else, move to forward pos
            row = nr;
            col = nc;
            q.addLast(new int[]{row, col});
            
            // if apple exists, keep tail, else cut
            if(graph[row][col] != APPLE) {
                int[] tail = q.pollFirst();
                graph[tail[0]][tail[1]] = EMPTY;
            }
            
            graph[row][col] = SNAKE;
            
            // if direction turn command at current time exists, change dir
            if(commandMap.containsKey(totalTime)) {
                int dd = commandMap.get(totalTime);
                dir = (dir + 4 + dd) % 4;
            }
        }
        
        System.out.println(totalTime);
    }
}