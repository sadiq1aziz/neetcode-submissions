class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // dp[i] -> max current length
        int [] dp = new int[nums.length];
        // init dp
        Arrays.fill(dp, 1);
        
        // max Len can reside in any indice, therefore
        // we need to check max 
        int maxLen = 1;

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
