class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int length = 1;
        long result = 0;
        
        for(var num: nums) {
            if(num == 0) result += length++;
            else length = 1;
        }
        
        return result;
    }
}