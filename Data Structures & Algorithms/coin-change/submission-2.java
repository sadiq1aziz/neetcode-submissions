class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0){
            return 0;
        }

        int[] dp = new int[amount+1];
        // init dp
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++){
            int coin = coins[i];
            for (int j = coin; j <= amount; j++){
                dp[j] = Math.min(dp[j], dp[j-coin] + 1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
