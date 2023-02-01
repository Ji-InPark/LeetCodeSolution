class Solution {
    public String gcdOfStrings(String str1, String str2) {
        var str = str1.length() > str2.length() ? str1 : str2;
        
        for(int i = str.length(); i > 0; i--) {
            var div = str.substring(0, i);
            
            if(str1.replace(div, "").length() == 0 && str2.replace(div, "").length() == 0) return div;
        }
        
        return "";
    }
}