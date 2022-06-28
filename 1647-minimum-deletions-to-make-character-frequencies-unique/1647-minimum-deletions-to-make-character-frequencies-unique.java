class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        HashMap<Integer, Boolean> map = new HashMap<>();
        int result = 0;
        
        for(char c : s.toCharArray()) arr[c - 'a']++;
        
        for(int num : arr)
        {
            if(num == 0) continue;
            
            if(map.containsKey(num))
            {
                while(num > 0 && map.containsKey(num)) 
                {
                    num--;
                    result++;
                }
            }
            map.put(num, true);
        }
        
        return result;
    }
}