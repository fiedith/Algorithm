class Solution {
    private static final int INF = 987654321;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // init
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] != INF ? dp[amount] : -1;
    }
}