class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int [] dp = new int[s.length()+1];
        dp[0] = 1; //"" is understood to be a decode of no characters
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // 0 is decodes as zero
        // two ways to decode - using 1(i-1th) character
        // or using 2 characters based on problem (i-2th, i-1th)
        for(int i = 2; i <= s.length(); i++){
            int last1 = Integer.parseInt(s.substring(i-1, i));
            int last2 = Integer.parseInt(s.substring(i-2, i));
            
            if (last1 >=1 && last1 <= 9){
                dp[i]+=dp[i-1];
            }
            
            if (last2 >= 10 && last2 <= 26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];


    }
}
