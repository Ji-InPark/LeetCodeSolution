class WordDictionary {
    Trie trie = new Trie();
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.find(word);
    }
}

class Trie {
    Trie[] tries = new Trie[26];
    boolean isEnd = false;
    
    public void insert(String word) {
        var trie = this;
        for(var c : word.toCharArray()) {
            int index = c - 'a';
            if(trie.tries[index] == null) trie.tries[index] = new Trie();
            trie = trie.tries[index];
        }
        trie.isEnd = true;
    }
    
    public boolean find(String word) {
        if(word.isEmpty()) return isEnd;
        
        var c = word.charAt(0);
        
        if(c == '.') {
            for(int i = 0; i < tries.length; i++) 
                if(tries[i] != null && tries[i].find(word.substring(1))) return true;
            
            return false;
        } 
        
        return tries[c - 'a'] != null && tries[c - 'a'].find(word.substring(1));
    }
}
