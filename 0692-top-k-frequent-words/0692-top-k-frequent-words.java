class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        var map = new HashMap<String, Node>();
        for(var word: words) {
            if(!map.containsKey(word)) map.put(word, new Node(word, 0));
            map.get(word).cnt++;
        }
        
        var pq = new PriorityQueue<Node>();
        
        for(var key: map.keySet()) pq.add(map.get(key));
        
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < k; i++) result.add(pq.poll().word);
        
        return result;
    }
    
    class Node implements Comparable<Node>{
        String word;
        int cnt;
        
        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cnt == n.cnt ? this.word.compareTo(n.word) : n.cnt - this.cnt;
        }
    }
}