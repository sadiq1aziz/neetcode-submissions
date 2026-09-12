class Solution {
    public int climbStairs(int n) {
        // using rolling DP to solve the problem
        if ( n < 2){
            return n;
        }

        //dp[1] ->1 step at a time to reach n
        int prev2 = 1;
        //dp[2] ->2 steps at a time to reach n
        int prev1 = 2;
        for (int i = 2; i < n; i++){
            // dp[i+1] = dp[i] + dp[i - 1]
            int res = prev1+prev2;
            prev2 = prev1;
            prev1 = res;
        }   
        return prev1;
    }
}
