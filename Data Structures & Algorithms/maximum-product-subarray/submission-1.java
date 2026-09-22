class Solution {
    public int maxProduct(int[] nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++){
            // find current prods
            int curMaxProd = nums[i]*maxProd;
            int curMinProd = nums[i]*minProd;
            
            // update max and min using current element and current prods
            maxProd = Math.max(nums[i], Math.max(curMinProd, curMaxProd));
            
            minProd = Math.min(nums[i], Math.min(curMinProd, curMaxProd));

            // get globalmax
            globalMax = Math.max(maxProd, globalMax);
        }
        return globalMax;
    }
}
