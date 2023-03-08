class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for(var p : piles) right = Math.max(right, p);
        
        while(left < right) {
            int mid = left + (right - left) / 2, hour = 0;
            
            for(var p : piles) hour += p / mid + (p % mid == 0 ? 0 : 1);
            
            if(hour > h) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}