class Solution {
    public int partitionString(String s) {
        var arr = new boolean[26];
        int left = 0, result = 1;
        
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a']) {
                while(left < i) arr[s.charAt(left++) - 'a'] = false;
                result++;
            }
            arr[s.charAt(i) - 'a'] = true;
        }
        
        return result;
    }
}