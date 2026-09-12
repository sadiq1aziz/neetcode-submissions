class Solution {
    public int climbStairs(int n) {
        //using rolling DP
        // check base 
        if (n < 2){
            return n;
        }
        
        //dp[] is the result where each cumulative step is accounted for
        //dp[0] = 1, dp[1] = 2

        int prev2 = 1;
        int prev1 = 2;
        for (int i = 2; i < n; i++){
            int res = prev2 + prev1;
            prev2 = prev1;
            prev1 = res;
        }
        return prev1;    
    }
}
