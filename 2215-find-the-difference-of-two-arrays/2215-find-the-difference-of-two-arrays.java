class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        
        for(var num: nums1) set1.add(num);
        for(var num: nums2) set2.add(num);
        
        var result = new ArrayList<List<Integer>>();
        
        var arr = new ArrayList<Integer>();
        for(var num: set1) if(!set2.contains(num)) arr.add(num);
        
        result.add(arr);
        
        arr = new ArrayList<Integer>();
        for(var num: set2) if(!set1.contains(num)) arr.add(num);
        
        result.add(arr);
        
        return result;
    }
}