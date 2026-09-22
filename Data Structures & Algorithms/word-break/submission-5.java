class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        // Use hashset to check if substring word is present in s
        HashSet<String> set = new HashSet<>(wordDict);
        // prefilled on init with false;
        // Since we are iterating from the start to the end sequentially processing the string input for words, we begin with a base case of dp and proceed till len+1
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;

        // as we process the whole string from base case it will be n-1 + base i.e s.length()
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                String str = s.substring(j,i);
                // check if clean break i.e current mark is true
                if (dp[j] && set.contains(str)){
                    dp[i] = true;
                    break;
                }
            }
        }
        // as we process the whole string from base case it will be n-1 + base i.e s.length()
        return dp[s.length()];
    }
}
