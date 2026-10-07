class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        // To set base states to build up dp @ i as we move along
        int[] dp = new int[s.length()+1];

        // intuition: last 2 chars from i
        dp[0] = 1; // ""
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // 0 cannot be decoded into anything from A-Z 
        // iterate toward end of dp i.e s.length()
        // while we parse s
        for (int i = 2; i <= s.length(); i++){
            // get last and last 2 chars
            int lastOne = Integer.parseInt(s.substring(i-1, i));
            int lastTwo = Integer.parseInt(s.substring(i-2, i));
            if (lastOne >= 1 && lastOne <= 9){
                // update dp[i] to include decode ways of previous last character 
                dp[i] += dp[i-1]; 
            }
            if (lastTwo >= 10 && lastTwo <= 26){
                // update dp[i] to include decode ways of previous last two character 
                dp[i] += dp[i-2]; 
            }
        }
        return dp[s.length()];
    }
}
