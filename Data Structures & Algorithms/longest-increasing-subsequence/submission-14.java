class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // i -> references each index of nums
        // dp[i] -> longest increasing subsequence @ i
        int [] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // Longest sequence seen overall
        int maxSeqLen = 1;
        for (int i = 1 ; i < nums.length; i++){
            for (int j = 0 ; j < i; j++){
               if (nums[j] < nums[i]){
                 dp[i] = Math.max(dp[i], dp[j] + 1);
               } 
            }
            maxSeqLen = Math.max(dp[i], maxSeqLen);
        }   
        return maxSeqLen;
    }
}
