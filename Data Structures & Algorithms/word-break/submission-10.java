class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null) return false;
        // convert collection of strings to hashSet collection
        HashSet<String> set = new HashSet<>(wordDict);
        // dp[i] -> for s[0 -> i-1] prefix to be a valid segment
        boolean [] dp = new boolean[s.length()+1];
        // init state needs to be true for a contiguos word break pattern to be valid
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0 ; j < i; j++){
                String str = s.substring(j, i);
                if (dp[j] && set.contains(str)){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length-1];
    }
}
