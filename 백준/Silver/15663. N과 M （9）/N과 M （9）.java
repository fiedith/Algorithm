import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;       // m개 뽑기
    private static List<Integer> numbers;
    private static StringBuilder result;
    private static boolean[] visited;
    private static Set<String> set;     // set to validate duplicate results

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();

        // 첫째 줄 n, m
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 둘째 줄 n개의 정수
        st = new StringTokenizer(br.readLine());
        numbers = new ArrayList<>();

        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);

        visited = new boolean[n];   // numbers 인덱스 순서대로
        set = new HashSet<>();
        dfs(0, new ArrayList<>());
        System.out.println(result.toString());
    }

    // depth, currentList
    private static void dfs(int count, List<Integer> currentList) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : currentList) {
                sb.append(num).append(" ");
            }
            String now = sb.toString();
            // validate duplicate string
            if (!set.contains(now)) {
                result.append(now).append("\n");
                set.add(now);
            }
        }

        // 매 depth마다 0부터 n까지 순서대로 확인, 미방문한 값을 방문
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                currentList.add(numbers.get(i));
                dfs(count + 1, currentList);
                currentList.remove(currentList.size() - 1);
                visited[i] = false;
            }
        }
    }
}