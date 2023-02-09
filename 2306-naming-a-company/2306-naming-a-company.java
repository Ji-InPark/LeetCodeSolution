class Solution {
    public long distinctNames(String[] ideas) {
        var arr = new HashSet[26];
        
        for(int i = 0; i < arr.length; i++) arr[i] = new HashSet<String>();
        
        for(var idea : ideas) arr[idea.charAt(0) - 'a'].add(idea.substring(1));
        
        long result = 0;
        
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                var set = new HashSet<String>();
                set.addAll(arr[i]);
                
                set.retainAll(arr[j]);
                int retainCnt = set.size();
                
                result += 2 * (arr[i].size() - retainCnt) * (arr[j].size() - retainCnt);
            }
        }
        
        return result;
    }
}