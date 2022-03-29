class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int fast = 0, slow = 0;
        
        fast = nums[nums[fast]];
        slow= nums[slow];
        
        while(nums[fast] != nums[slow])
        {
            fast = nums[nums[fast]];
            slow= nums[slow];
        }
        
        fast = 0;
        while(nums[fast] != nums[slow])
        {
            fast = nums[fast];
            slow= nums[slow];
        }
        
        return nums[fast];
    }
};