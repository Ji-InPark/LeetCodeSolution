class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        return result < 0 ? result * -1 - 1 : result;
    }
}