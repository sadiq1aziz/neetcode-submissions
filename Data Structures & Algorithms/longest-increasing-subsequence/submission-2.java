class Solution {
    public int lengthOfLIS(int[] nums) {
        // create a dp array to store res against each index
        //  num-> [9,1,4,2,3,3,7]
        //  dp -> [1,1,2,2,3,3,4]
        //  ind->  0,1,2,3,4,5,
        int[] dp = new int[nums.length];
        // default length will be 1
        int maxLen = 1;
        // use a double loop to iterate through the sequence
        for ( int i = 0; i < nums.length; i++ ){  
            // initialize dp[i] to 1 as that is he current length
            dp[i] = 1;
            // since we compare different elements and not itself j < i
            for ( int j = 0 ; j < i; j++ ){
                // for strictly increasing sequence we compare just the two elements @j, i 
                if ( nums[j] < nums[i]){
                    // if a preceeding indice j has a value less than at i
                    dp[i] = Math.max(dp[i], dp[j]+1); 
                }
            }   
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
