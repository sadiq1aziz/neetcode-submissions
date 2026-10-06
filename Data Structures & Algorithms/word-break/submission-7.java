class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        boolean [] dp = new boolean [s.length()+1];
        dp[0] = true;

        // i does two things:
        //1. iterate through string to get substring till i(non inclusive) hence out of bounds isnt an issue as we dont use s[i] directly in block code
        //2. i is directly used in dp, dp[i] spans from 0 -> s.length()+1
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                String str = s.substring(j, i);
                if (dp[j] && set.contains(str)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
