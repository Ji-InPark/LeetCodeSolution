class Solution {
    public int[] findErrorNums(int[] nums) {
        var arr = new int[nums.length + 1];
        
        for(var num : nums) arr[num]++;
        
        
        int dup = 0, none = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 2) dup = i;
            if(arr[i] == 0) none = i;
        }
        
        return new int[]{dup, none};
    }
}