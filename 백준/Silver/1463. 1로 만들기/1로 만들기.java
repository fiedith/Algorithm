import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 987654321);
        dp[n] = 0;

        for (int i = n; i > 1; i--) {
            if(i % 3 == 0){
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }

            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }

            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }

        System.out.println(dp[1]);
    }
}