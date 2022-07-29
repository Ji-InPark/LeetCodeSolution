class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int index = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int[] parr = new int[pattern.length()];
        
        for(int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), index++);
            }
            parr[i] = map.get(pattern.charAt(i));
        }
        
        List<String> result = new ArrayList<>();
        
        for(String word: words) {
            int[] temp = new int[26];
            HashMap<Integer, Character> tempmap = new HashMap<>();
            boolean flag = true;
            
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!tempmap.containsKey(parr[i])) {
                    if(temp[c - 'a'] != 0) {
                        flag = false;
                        break;
                    }
                    tempmap.put(parr[i], c);
                    temp[c - 'a'] = parr[i];
                }
                
                if(tempmap.get(parr[i]) != c) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) result.add(word);
        }
        
        return result;
    }
}