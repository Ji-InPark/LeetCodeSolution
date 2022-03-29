class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] count = new boolean[100005];
        
        for(int num : nums)
        {
            if(count[num])
                return num;
            else
                count[num] = true;
        }
        
        return 0;
    }
}