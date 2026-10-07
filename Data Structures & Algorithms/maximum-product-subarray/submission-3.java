class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++){
            int curMaxProd = nums[i]*maxProd;
            int curMinProd = nums[i]*minProd;
            
            maxProd = Math.max(nums[i], Math.max(curMaxProd, curMinProd));
            minProd = Math.min(nums[i], Math.min(curMaxProd, curMinProd));
            maxGlobal = Math.max(maxGlobal, maxProd);
        }
        return maxGlobal;
    }
}
