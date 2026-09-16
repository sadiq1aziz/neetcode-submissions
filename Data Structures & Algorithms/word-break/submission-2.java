class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        
        // consider base case at dp[0] 
        dp[0] = true;

        // we need to ensure clean breaks of words in the string
        // any garbage char would lead to being marked as false;
        // use double loops with convergence algorithm
        // 0 -> j <-> i-1 | shrink from 0 -> i-1 
        for (int i = 1; i <= s.length(); i++){
                for (int j = 0 ; j < i ; j++){
                    // check if dp[j] == true , ensures last substring is in dict
                    if (dp[j] && set.contains(s.substring(j, i))){
                        // mark current index as true;
                        dp[i] = true;
                        break;
                    }
                }              
        }
        return dp[s.length()];
    }
}
