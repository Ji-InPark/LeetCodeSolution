class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        var result = new ArrayList<Integer>();
        for(var num: nums) {
            var index = Math.abs(num) - 1;
            if(nums[index] < 0) {
                result.add(index + 1);
            } else {
                nums[index] *= -1;
            }
        }
        
        return result;
    }
}