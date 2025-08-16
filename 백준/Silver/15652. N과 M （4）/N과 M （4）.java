import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;

    public static void dfs(int start, int count, List<Integer> currentList) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : currentList) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = start; i <= n; i++) {
            currentList.add(i);
            dfs(i, count + 1, currentList);
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
    }
}