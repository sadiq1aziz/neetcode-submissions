class Solution {
    public int climbStairs(int n) {
        if (n == 0)return 0;
        int prev2 = 0;
        int prev1 = 1;

        for (int i = 0; i < n; i++){
            int res = prev1+prev2;
            prev2 = prev1;
            prev1 = res;
        }
        return prev1;
    }
}
