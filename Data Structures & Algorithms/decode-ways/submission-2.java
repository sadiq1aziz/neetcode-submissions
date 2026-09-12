class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        // dp[i] = ways to decode substring s[0..i-1]
        dp[0] = 1;  
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {

            int last1 = Integer.parseInt(s.substring(i - 1, i));      // last 1 digit
            int last2 = Integer.parseInt(s.substring(i - 2, i));      // last 2 digits

            // valid single digit decode (1–9)
            if (last1 >= 1 && last1 <= 9) {
                dp[i] += dp[i - 1];
            }

            // valid double digit decode (10–26)
            if (last2 >= 10 && last2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
