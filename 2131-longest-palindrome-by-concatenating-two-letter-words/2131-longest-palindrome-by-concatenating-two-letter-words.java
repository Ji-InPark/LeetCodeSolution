class Solution {
    public int longestPalindrome(String[] words) {
        var map = new HashMap<String, Integer>();
        var set = new HashSet<String>();
        int result = 0;
        
        for(var word: words) {
            int count = map.getOrDefault(reverse(word), 0);
            
            if(count > 0) {
                if(word.equals(reverse(word))) set.remove(word);
                
                map.put(reverse(word), count - 1);
                
                result += 4;
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
                
                if(word.equals(reverse(word))) set.add(word);
            }
        }
        
        if(set.size() > 0) result += 2;
        
        return result;
    }
    
    public String reverse(String str) {
        return new String(new char[]{str.charAt(1), str.charAt(0)});
    }
}