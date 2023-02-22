class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = 0;
        for(var w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        
        int left = max, right = sum;
        
        while(left <= right) {
            int count = 0, s = 0, mid = left + (right - left) / 2;
            
            for(var w : weights) {
                if(s + w > mid) {
                    s = 0;
                    count++;
                }
                
                s += w;
            }
            
            if(count >= days) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
}