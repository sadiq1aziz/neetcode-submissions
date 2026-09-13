class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2)return Math.max(nums[0], nums[1]);

        return Math.max(robHouse(nums, 0, nums.length - 2), robHouse(nums, 1, nums.length - 1));
    }

    private int robHouse(int[] nums, int start, int end){        
        int prev1 = Math.max(nums[start], nums[start+1]);
        int prev2 = nums[start];
        for (int i = start+2; i <= end; i++){
            int res = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = res;
        }
        return prev1;
    }
}
