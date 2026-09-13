class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int maxPile = 0;
         for (int pile : piles){
            maxPile = Math.max(pile, maxPile);
         }

         int left = 1;
         // we  take this as a maximum potential rate that we search behind to find the actual minimal rate
         int right = maxPile;
         while (left < right){
            int mid = left + (right - left ) / 2;
            boolean isRateCovered = getEatRate(piles, mid, h);
            if (isRateCovered){
                right = mid;
            } else {
                left = mid + 1;
            }
         }
         return right;
    }

    private boolean getEatRate(int [] piles, int rate, int h){
        // get the time taken at current rate to finish piles
        int t = 0;
        for (int pile : piles){
            t += ((pile+rate-1)/rate);
        }
        if (t <= h){
            return true;
        }
        return false;
    }
}
