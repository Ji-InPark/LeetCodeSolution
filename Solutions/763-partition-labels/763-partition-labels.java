class Solution {
    public List<Integer> partitionLabels(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] dp = new int[input.length()];
        int index = 0;
        
        for(int i = 0; i < input.length(); i++)
        {
            char now = input.charAt(i);
            
            if(map.containsKey(now))
            {
                for(int j = map.get(now) + 1; j <= i; j++)
                {
                    dp[j] = dp[map.get(now)];
                }
                map.put(now, i);
            }
            else
            {
                dp[i] = index++;
                map.put(now, i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int pre = 0;
        for(int i = 0; i < input.length(); i++)
        {
            if(dp[pre] != dp[i])
            {
                result.add(i - pre);
                pre = i;
            }
        }
        result.add(input.length() - pre);
        
        return result;
    }
}