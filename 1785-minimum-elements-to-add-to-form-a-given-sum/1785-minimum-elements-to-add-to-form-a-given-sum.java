class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(var num: nums) sum += num;
        
        long diff = Math.abs((long)goal - sum);
        
        return (int)(diff / limit + (diff % limit > 0 ? 1 : 0));
    }
}