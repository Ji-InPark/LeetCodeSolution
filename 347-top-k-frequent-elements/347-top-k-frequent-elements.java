class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] arr = new ArrayList[nums.length + 1];
        
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if(arr[map.get(num)] == null) arr[map.get(num)] = new ArrayList<Integer>();
            
            arr[map.get(num)].add(num);
        }
        
        int[] result = new int[k];
        int index = 0;
        
        Loop:
        for(int i = nums.length; i >= 0; i--)
        {   
            if(arr[i] == null) continue;
            
            for(int j = 0; j < arr[i].size(); j++)
            {
                if(map.containsKey(arr[i].get(j)))
                {
                    map.remove(arr[i].get(j));
                    result[index++] = arr[i].get(j);
                }
                
                if(index == k) break Loop;       
            }
        }
        
        return result;
    }
}