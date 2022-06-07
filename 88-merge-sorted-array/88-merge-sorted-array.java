class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int index = 0, index1 = 0, index2 = 0;
        
        while(index1 < m && index2 < n)
        {
            nums[index++] = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
        }
        
        while(index1 < m)
        {
            nums[index++] = nums1[index1++];
        }
        while(index2 < n)
        {
            nums[index++] = nums2[index2++];
        }
        
        for(int i = 0; i < nums.length; i++) nums1[i] = nums[i];
    }
}