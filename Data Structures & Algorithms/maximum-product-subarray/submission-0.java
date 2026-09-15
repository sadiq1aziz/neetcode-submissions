class Solution {
    public int maxProduct(int[] nums) {
        // need to get moving products as we iterate through the array
        int minPd = nums[0];
        int maxPd = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            int curMaxPd = maxPd*nums[i];
            int curMinPd = minPd*nums[i];
            
            // update min and max
            maxPd = Math.max(nums[i], Math.max(curMaxPd, curMinPd));
            minPd = Math.min(nums[i], Math.min(curMaxPd, curMinPd));
            
            globalMax = Math.max(globalMax, maxPd);
        }
        return globalMax; 
    }
}
