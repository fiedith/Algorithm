import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int stories = Integer.parseInt(st.nextToken());
        int init = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        final String NONE = "use the stairs";
        
        // edge cases
        if((init > target && d == 0) || (init < target && u == 0)) {
            System.out.println(NONE);
            return;
        }
        
        if(init == target) {
            System.out.println(0);
            return;
        }
        
        // [0] = val, [1] = count
        Deque<int[]> q = new ArrayDeque<>();
        
        // visited floors
        boolean[] visited = new boolean[stories + 1];
        
        q.addLast(new int[]{init, 0});
        
        while(!q.isEmpty()) {
            int[] polled = q.pollFirst();
            int val = polled[0];
            int count = polled[1];
            
            int uVal = val + u;
            int dVal = val - d;
            
            // if next upper or under val equals target, return
            if(uVal == target || dVal == target) {
                System.out.println(count + 1);
                return;
            }
            
            // else, add next in-bounds & non-visited upper and under vals
            if(uVal <= stories && !visited[uVal]) {
                q.addLast(new int[]{uVal, count + 1});
                visited[uVal] = true;
            }
            if(dVal > 0 && !visited[dVal]) {
                q.addLast(new int[]{dVal, count + 1});
                visited[dVal] = true;
            }
            
        }
        
        // if not returned within bfs
        System.out.println(NONE);
        return;
    }
}