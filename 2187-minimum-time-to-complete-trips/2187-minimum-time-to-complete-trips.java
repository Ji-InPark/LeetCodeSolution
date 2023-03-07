class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0, right = 100000000000000l;
        
        while(left < right) {
            long mid = left + (right - left) / 2;
            long midResult = 0;
            
            for(var t : time) midResult += mid / t;
            
            if(midResult < totalTrips) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}