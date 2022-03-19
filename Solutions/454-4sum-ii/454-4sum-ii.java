class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums1.length; i++)
        {
            for(int j = 0; j < nums2.length; j++)
            {
                if(!map.containsKey(nums1[i] + nums2[j]))
                    map.put(nums1[i] + nums2[j], 0);
                map.put(nums1[i] + nums2[j], map.get(nums1[i] + nums2[j]) + 1);
            }
        }

        for(int i = 0; i < nums3.length; i++)
        {
            for(int j = 0; j < nums4.length; j++)
            {
                if(map.containsKey(-1 * (nums3[i] + nums4[j])))
                    result += map.get(-1 * (nums3[i] + nums4[j]));
            }
        }
        
        return result;
    }
    
}