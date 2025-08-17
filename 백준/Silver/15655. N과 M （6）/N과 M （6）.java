import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

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

        dfs(0, 0, new ArrayList<>());
        System.out.println(result.toString());
    }

    // start idx, depth, currentList
    private static void dfs(int start, int count, List<Integer> currentList) {
        if (count == m) {
            for (int num : currentList) {
                result.append(num).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            currentList.add(numbers.get(i));
            dfs(i + 1, count + 1, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}