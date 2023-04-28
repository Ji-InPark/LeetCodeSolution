class Solution {
    HashSet<String> set = new HashSet<>();
    String[] strs;
    public int numSimilarGroups(String[] strs) {
        this.strs = strs;
        int result = 0;
        
        for(var str: strs) {
            if(set.contains(str)) continue;
            set.add(str);
            solve(str);
            result++;
        }
        
        return result;
    }
    
    private void solve(String str1) {
        for(var str2: strs) {
            if(set.contains(str2)) continue;
            
            var arr1 = str1.toCharArray();
            var arr2 = str2.toCharArray();
            
            int diff = 0;
            for(int i = 0; i < arr1.length && diff <= 2; i++) {
                if(arr1[i] != arr2[i]) diff++;
            }
            
            if(diff == 2) {
                set.add(str2);
                solve(str2);
            }
        }
    }
}