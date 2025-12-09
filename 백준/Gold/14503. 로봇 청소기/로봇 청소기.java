import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 필수
        StringTokenizer st; // 한 줄에 여러 내용 한꺼번에 입력받을 시 필요
        
        // rows, cols
        st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        
        // N -> E -> S -> W
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        
        // rowpos, colpos, dir
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        
        // graph
        int[][] graph = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < cols; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean[][] visited = new boolean[rows][cols];
        boolean isBlocked = false;
        int result = 0;
        
        while(!isBlocked) {
            // 1: fill in current block (will always be given as movable position)
            if(!visited[r][c]) {
                visited[r][c] = true;
                result++;
            }
            
            boolean canMove = false;
            // 2: check four sides reverse clockwise
            for(int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                // if out of bounds or wall or visited, cannot move
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || graph[nr][nc] == 1 || visited[nr][nc]) {
                    continue;
                } else {
                    canMove = true;
                    r = nr;
                    c = nc;
                    break;
                }
            }
            
            // 3: if cannot move, try to move back (only considers wall or outofbounds)
            if(!canMove) {
                int nr = r - dr[dir];
                int nc = c - dc[dir];
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || graph[nr][nc] == 1) {
                    isBlocked = true;
                } else{
                    r = nr;
                    c = nc;
                }
            }
        }
        
        System.out.println(result);
    }
}