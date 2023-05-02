class Solution {
    public int arraySign(int[] nums) {
        int result = 1;
        for(var num: nums) {
            if(num == 0) return 0;
            result *= num > 0 ? 1 : -1;
        }
        return result;
    }
}