class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int [] dp = new int[nums.length];
        // each element is a sequence of 1
        Arrays.fill(dp, 1);
        int longest = 1;
        // dp[i] -> longest sequence at i
        for (int i = 1 ; i < nums.length ; i++){
            for (int j = 0; j < i ; j++){
                // 3 2 1 4 3 6 7
                // check up to i
                // track current value against 
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
              longest = Math.max(dp[i], longest);
        }
        return longest;
    }
}
