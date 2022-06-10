class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean[] selected = new boolean[256];
        int first = 0, second = 0, result = 0, sum = 0;
        
        if(s.length() == 0)
            return 0;
        
        
        for(first = 0; first < s.length(); first++)
        {
            if(!selected[s.charAt(first)])
            {
                selected[s.charAt(first)] = true;
                sum++;
                result = Math.max(sum, result);
            }
            else
            {
                while(s.charAt(first) != s.charAt(second++))
                {
                    selected[s.charAt(second - 1)] = false;
                    sum--;
                }
            }
        }
        
        return result;
    }
}