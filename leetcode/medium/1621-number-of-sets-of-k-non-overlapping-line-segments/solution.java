class Solution {
    int MOD = 1_000_000_007;
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int K) {

        for (int i = 0; i <= n; i++) {
            dp[0][i] = (i < n) ? 1 : 0;
        }

        for (int k = 1; k <= K; k++) {

            for (int i = n - 1; i >= 0; i--) {

                int skip = dp[k][i + 1];

                int take = 0;
                for (int j = i + 1; j < n; j++) {
                    take = (int) ((take + dp[k - 1][j]) % MOD);
                }

                dp[k][i] = (take + skip) % MOD;
            }
        }

        return dp[K][0];
    }
}