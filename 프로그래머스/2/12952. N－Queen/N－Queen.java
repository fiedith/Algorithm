import java.util.*;

class Solution {
    private static boolean[] visited;    // 직선 검증
    private static Set<Integer> asc;        // 우상향 대각선 검증
    private static Set<Integer> desc;       // 우하향 대각선 검증
    private static int result;
    private static int N;

    public static int solution(int n) {
        N = n;
        visited = new boolean[n];
        result = 0;
        asc = new HashSet<>();
        desc = new HashSet<>();

        dfs(0);
        return result;
    }

    // start row pos, count
    private static void dfs(int row){
        // 인자로 넘어온 row값이 n인 경우 맵 초과, 즉 최적해를 발견한 상태
        if(row == N){
            result++;
            return;
        }

        for(int col = 0; col < N; col++){
                if(!visited[col] && !asc.contains(row + col) && !desc.contains(row - col)){
                visited[col] = true;
                asc.add(col + row);
                desc.add(row - col);
                dfs(row + 1);
                desc.remove(row - col);     // 이하 원상복구
                asc.remove(col + row);
                visited[col] = false;
            }
        }
    }
}