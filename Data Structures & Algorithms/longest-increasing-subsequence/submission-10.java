class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;
        int [] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // dp[i] = longest increasing sequence till index i
        // 2 way iterations
        for (int i = 1 ; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                // take max of current val @ i vs val @ j + 1 if ascending
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
