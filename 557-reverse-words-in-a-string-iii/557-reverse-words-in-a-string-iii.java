class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String str : s.split(" ")) sb.append(reverse(str) + " ");
        return sb.toString().trim();
    }
    
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}