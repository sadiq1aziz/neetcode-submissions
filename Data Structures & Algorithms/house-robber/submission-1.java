class Solution {
    public int rob(int[] nums) {
        //using rolling DP
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);

        return robHouse(nums, 0, nums.length);
    }

    private int robHouse(int [] arr, int startHouseIndex, int endHouseIndex){
        int prev2 = arr[startHouseIndex];
        int prev1 = Math.max(arr[startHouseIndex+1], arr[startHouseIndex]);
        for (int i = startHouseIndex+2; i < endHouseIndex; i++ ){
            int currentAmt = arr[i];
            int maxAmt = Math.max(currentAmt+prev2, prev1);
            prev2 = prev1;
            prev1 = maxAmt;
        }
        return prev1;
    }
}
