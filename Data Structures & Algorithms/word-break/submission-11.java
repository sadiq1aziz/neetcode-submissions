class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict.isEmpty()){
            return true;
        }
    
        // dp value = t f f f t f f f t
        // dp index = 0 1 2 3 4 5 6 7 8 
        // string s = n e e t c o d e 
        boolean [] dp = new boolean[s.length() + 1];
        // init dp
        dp[0] = true;
        HashSet set = new HashSet(wordDict);

        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < i; j++){
                // substring for neet -> s[0..i-1]
                String str = s.substring(j, i);
                if(dp[j] && set.contains(str)){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
