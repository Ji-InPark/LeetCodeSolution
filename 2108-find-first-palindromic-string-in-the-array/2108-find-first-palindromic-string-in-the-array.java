class Solution {
    public String firstPalindrome(String[] words) {
        for(var word: words) if(isPalindrome(word)) return word;
        
        return "";
    }
    
    private boolean isPalindrome(String word) {
        int length = word.length();
        var arr = word.toCharArray();
        
        for(int i = 0; i < length / 2; i++) {
            if(arr[i] != arr[length - i - 1]) return false;
        }
        
        return true;
    }
}