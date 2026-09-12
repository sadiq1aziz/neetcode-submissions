class Solution {
    public int climbStairs(int n) {
        int prev1 = 0;
        int prev2 = 1;
        int res = 0;
        //dp[i] = dp[i-1] + dp[i-2]
        for (int i = 0 ; i < n; i++){
            res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;    
        }
        return res;
    }
}
