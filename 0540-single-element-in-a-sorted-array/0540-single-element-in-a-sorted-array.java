class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            
            if(mid == 0 || mid == nums.length - 1) {
                return nums[mid];
            } else if(nums[mid] == nums[mid - 1]) {
                if(mid % 2 == 1) l = mid + 1;
                else r = mid - 1;
            } else if(nums[mid] == nums[mid + 1]) {
                if(mid % 2 == 0) l = mid + 1;
                else r = mid - 1;
            } else {
                return nums[mid];
            }
        }
        
        return 0;
    }
}