class Trie {
    Trie[] tries = new Trie[26];
    boolean isEnd = false;

    public void insert(String word) {
        if(word.isEmpty()) {
            isEnd = true;
            return;
        }
        
        int index = word.charAt(0) - 'a';
        
        if(tries[index] == null) tries[index] = new Trie();
        tries[index].insert(word.substring(1));
    }
    
    public boolean search(String word) {
        if(word.isEmpty()) return isEnd;
        
        int index = word.charAt(0) - 'a';
        
        return tries[index] != null && tries[index].search(word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.isEmpty()) return true;
        
        int index = prefix.charAt(0) - 'a';
        
        return tries[index] != null && tries[index].startsWith(prefix.substring(1));
    }
}
