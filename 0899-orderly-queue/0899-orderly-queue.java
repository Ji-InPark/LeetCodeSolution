class Solution {
    public String orderlyQueue(String s, int k) {
        var sb = new StringBuilder(s + s);
        var result = s;
        
        if(k == 1) {
            for(int i = 0; i < s.length(); i++) {
                var substring = sb.substring(i, i + s.length());
                
                if(result.compareTo(substring) > 0) result = substring;
            }
            return result;
        }
        
        var arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}