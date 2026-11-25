class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        // track maxlen at any given point
        int maxLen = 1;
        // contains current sequence length at i
        int[] dp = new int[nums.length];
        // init dp array with 1 as min len
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
