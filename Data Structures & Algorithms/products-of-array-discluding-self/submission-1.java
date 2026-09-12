class Solution {
    public int[] productExceptSelf(int[] nums) {
        //prefix
        int [] res = new int[nums.length];
        //prepopulate first element
        res[0] = 1;
        //left to right
        for ( int i = 1; i < nums.length; i++){
            res[i] = res[i-1]*nums[i-1];
        }

        //suffix product
        int suffixProduct = 1;
        //right to left
        for (int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i]*suffixProduct;
            suffixProduct*=nums[i];
        }

        return res;

    }
}  
