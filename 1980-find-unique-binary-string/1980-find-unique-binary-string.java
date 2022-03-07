class Solution {
    String result;
    HashMap<String, String> map = new HashMap<String, String>();
    int max;
    public String findDifferentBinaryString(String[] nums) {
        max = nums.length;
        for(String num : nums)
            map.put(num, num);
        
        find("", 0);
        
        return result;
    }
    
    public void find(String temp, int level)
    {
        if(level == max)
        {
            if(map.containsKey(temp))
                return;
            result = temp;
            return;
        }
        
        if(result != null)
            return;
        
        find(temp + "0", level + 1);
        find(temp + "1", level + 1);
    }
}