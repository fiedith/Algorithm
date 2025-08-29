import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    static final int INF = 987654321;

    static class Node {
        int value;
        int idx;
        Node origin;

        public Node(int value, int idx, Node origin) {
            this.value = value;
            this.idx = idx;
            this.origin = origin;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] dp = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = new Node(INF, i, null);
        }

        dp[n].value = 0;

        // 나누어 떨어지며 값 갱신 가능한 경우들 (i - 1 제외)
        for (int i = n; i > 1; i--) {
            if (i % 3 == 0 && dp[i / 3].value > dp[i].value) {
                dp[i / 3].value = dp[i].value + 1;
                dp[i / 3].origin = dp[i];
            }

            if (i % 2 == 0 && dp[i / 2].value > dp[i].value) {
                dp[i / 2].value = dp[i].value + 1;
                dp[i / 2].origin = dp[i];
            }

            if (dp[i - 1].value > dp[i].value) {
                dp[i - 1].value = dp[i].value + 1;
                dp[i - 1].origin = dp[i];
            }

        }

        List<Integer> path = new ArrayList<>();

        Node curr = dp[1];

        while (curr != null) {
            path.add(curr.idx);
            curr = curr.origin;
        }

        System.out.println(dp[1].value);    // 최소 횟수부터 출력

        // 경로 출력
        StringBuilder sb = new StringBuilder();
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}