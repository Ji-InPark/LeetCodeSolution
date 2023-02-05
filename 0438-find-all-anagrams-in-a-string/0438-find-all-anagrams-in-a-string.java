class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var result = new ArrayList<Integer>();
        if(s.length() < p.length()) return result;
        
        var arr = new int[26];
        int n = p.length(), sum = n;
        
        for(var c : p.toCharArray()) arr[c - 'a']++;
        
        for(int i = 0; i < n; i++) if(arr[s.charAt(i) - 'a']-- > 0) sum--;
        
        if(sum == 0) result.add(0);
        
        for(int i = n; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a']-- > 0) sum--;
            if(++arr[s.charAt(i - n) - 'a'] > 0) sum++;
            if(sum == 0) result.add(i - n + 1);
        }
        
        return result;
    }
}