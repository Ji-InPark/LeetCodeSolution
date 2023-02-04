class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        var arr = new int[26];
        int n = s1.length(), sum = n;
        
        for(var c : s1.toCharArray()) arr[c - 'a']++;
        
        for(int i = 0; i < n; i++) if(arr[s2.charAt(i) - 'a']-- > 0) sum--;
        
        if(sum == 0) return true;
        
        for(int i = n; i< s2.length(); i++) {
            if(arr[s2.charAt(i) - 'a']-- > 0) sum--;
            if(++arr[s2.charAt(i - n) - 'a'] > 0) sum++;
            if(sum == 0) return true;
        }
            
        return false;
    }
}