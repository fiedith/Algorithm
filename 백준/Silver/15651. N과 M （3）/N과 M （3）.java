import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static StringBuilder result = new StringBuilder();

    private static void dfs(int start, int count, List<Integer> currentList) {
        if (count == m) {
            for (int num : currentList) {
                result.append(num).append(" ");
            }
            result.append("\n");        // 결과 모아놓고 한번에 출력
            return;
        }

        for (int i = start; i <= n; i++) {
            currentList.add(i);
            dfs(1, count + 1, currentList);     // 매 depth에서 반복되는 시작점은 항상 1
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> currentList = new ArrayList<>();
        dfs(1, 0, currentList);

        System.out.print(result.toString()); // 결과 모아놓고 한번만 출력
    }
}