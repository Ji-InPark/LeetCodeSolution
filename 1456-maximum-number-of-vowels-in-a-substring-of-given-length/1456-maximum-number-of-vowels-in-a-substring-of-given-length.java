class Solution {
    public int maxVowels(String s, int k) {
        var set = new HashSet<Character>(){{add('a'); add('e'); add('i'); add('o'); add('u');}};
        int sum = 0, result = 0;
        
        for(int i = 0; i < k; i++) {
            if(set.contains(s.charAt(i))) sum++;
        }
        
        result = sum;
        
        for(int i = k; i< s.length(); i++) {
            if(set.contains(s.charAt(i))) sum++;
            if(set.contains(s.charAt(i - k))) sum--;
            
            result = Math.max(result, sum);
        }
        
        return result;
    }
}