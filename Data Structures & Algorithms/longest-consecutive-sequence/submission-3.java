class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for (int num : set){
            // mark start of the sequence
            if (!set.contains(num-1)){
                int len = 1;
                while (set.contains(num+1)){
                    len += 1;
                    num+=1;
                }
                maxLen = Math.max(maxLen, len);
            }        
        }
        return maxLen;
    }
}
