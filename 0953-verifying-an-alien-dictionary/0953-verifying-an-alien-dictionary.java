class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        var arr = new int[26];
        
        for(int i = 0; i < 26; i++) arr[order.charAt(i) - 'a'] = i;
        
        Loop:
        for(int i = 1; i < words.length; i++) {
            var ps = words[i - 1];
            var ns = words[i];
            for(int j = 0; j < Math.min(ps.length(), ns.length()); j++) {
                if(arr[ps.charAt(j) - 'a'] > arr[ns.charAt(j) - 'a']) return false;
                else if(arr[ps.charAt(j) - 'a'] == arr[ns.charAt(j) - 'a']) continue;
                else continue Loop;
            }
            if(ps.length() > ns.length()) return false;
        }
        
        return true;
    }
}