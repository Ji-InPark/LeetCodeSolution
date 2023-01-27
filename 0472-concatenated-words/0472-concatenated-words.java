class Solution {
    HashSet<String> set = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        var result = new ArrayList<String>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for(var w : words) {
            for(int i = 1; i < w.length(); i++) {
                if(set.contains(w.substring(0, i)) && solve(i, w)) {
                    result.add(w);
                    break;
                }
            }
            set.add(w);
        }
        
        return result;
    }
    
    public boolean solve(int start, String word) {
        if(start == word.length()) return true;
        
        for(int i = start + 1; i <= word.length(); i++) if(set.contains(word.substring(start, i)) && solve(i, word)) return true;
        
        return false;
    }
}