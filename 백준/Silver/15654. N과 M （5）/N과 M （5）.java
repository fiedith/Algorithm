import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Map<Integer, Boolean> visited;
    private static int n;
    private static int m;       // m개 뽑기
    private static List<Integer> numbers;
    private static StringBuilder result;

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

        visited = new HashMap<>();
        for (int num : numbers) {
            visited.put(num, false);
        }

        List<Integer> currentList = new ArrayList<>();
        dfs(0, currentList);
        System.out.println(result.toString());
    }

    // current depth, currentList
    private static void dfs(int count, List<Integer> currentList) {
        if (count == m) {
            for (int val : currentList) {
                result.append(val).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            // 0부터 n까지 뒤져서 방문 안한 곳으로 진입 (가지치기)
            int currentNum = numbers.get(i);
            if (visited.get(currentNum).equals(false)) {
                visited.put(currentNum, true);
                currentList.add(currentNum);
                dfs(count + 1, currentList);
                currentList.remove(currentList.size() - 1);
                visited.put(currentNum, false);     // 원상복구
            }
        }
    }
}