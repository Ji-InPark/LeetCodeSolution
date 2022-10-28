class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var countSet = new HashMap<String, ArrayList<String>>();
        
        for(var str: strs) {
            var keyArr = new char[26];
            
            for(var c : str.toCharArray()) keyArr[c - 'a']++;
            
            String key = new String(keyArr);
            
            if(!countSet.containsKey(key)) countSet.put(key, new ArrayList<>());
            
            countSet.get(key).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for(var keySet : countSet.entrySet()) result.add(keySet.getValue());
        
        return result;
    }
}