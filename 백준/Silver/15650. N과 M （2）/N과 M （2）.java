import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;   // 1 ~ n 범위의 수
    private static int m;   // 총 m개의 수를 뽑음
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];   // 1-based array
        List<Integer> currentList = new ArrayList<>();
        dfs(1, 0, currentList);
    }

    private static void dfs(int pos, int count, List<Integer> currentList) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : currentList) {
                sb.append(num).append(" ");     //  오답일 시 마지막 요소만 append안하도록 수정
            }
            System.out.println(sb.toString());
            return;
        }

        // 현재 번호를 방문, 리스트에 추가, 다음 호출
        for (int i = pos; i <= n; i++) {
            // dfs 초기 인자로 주어진 pos가 방문된 번호가 아닌 경우에만 재귀호출을 준비
            if (!visited[pos]) {
                visited[i] = true;
                currentList.add(i);
                dfs(i + 1, count + 1, currentList);
                visited[i] = false;
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
