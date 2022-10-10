class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        
        var arr = palindrome.toCharArray();
        
        for(var i = 0; i < arr.length / 2; i++) {
            if(arr[i] != 'a') {
                arr[i] = 'a';
                break;
            }
        }
        
        if(palindrome.equals(new String(arr))) {
            arr[arr.length - 1] = arr[arr.length - 1] == 'a' ? 'b' : 'a';
        }
        
        var result = new String(arr);
        
        return result.equals(palindrome) ? "" : result;
    }
}