class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1 = 0, i2 = 0;
        var sb = new StringBuilder();
        
        while(i1 < word1.length() && i2 < word2.length()) {
            sb.append(word1.charAt(i1++));
            sb.append(word2.charAt(i2++));
        }
        
        while(i1 < word1.length()) sb.append(word1.charAt(i1++));
        while(i2 < word2.length()) sb.append(word2.charAt(i2++));
        
        return sb.toString();
    }
}