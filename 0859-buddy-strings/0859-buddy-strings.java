class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        
        var indexArr = new int[2];
        var charArr = new int[26];
        var flag = false;
        var index = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(index == 2) return false;
                
                indexArr[index++] = i;
            } else {
                if(charArr[s.charAt(i) - 'a']++ > 0) flag = true;
            }
        }
        
        if(index == 2) return s.charAt(indexArr[0]) == goal.charAt(indexArr[1]) && s.charAt(indexArr[1]) == goal.charAt(indexArr[0]);
        
        return index == 0 && flag;
    }
}