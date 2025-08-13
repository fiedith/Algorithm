import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] nums;
    private static boolean[] visited;
    // 1 ~ n의 n개 중 m개 뽑기
    private static int n;   // 1 ~ n 범위의 수
    private static int m;   // 총 m개의 수 뽑아 구성(nums의 길이)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m];
        visited = new boolean[n + 1];   // 1-based array
        func(0);
    }

    private static void func(int pos) {
        if (pos == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        // 1 ~ n 범위 내 backtrack
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[pos] = i;
                func(pos + 1);
                visited[i] = false;     // 복구 -> backtrack
            }
        }
    }
}
