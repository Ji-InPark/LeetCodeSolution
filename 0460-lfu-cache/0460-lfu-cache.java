class LFUCache {
    int capacity, minCnt = 0;
    HashMap<Integer, Integer> cnt = new HashMap<>();
    TreeMap<Integer, LinkedHashSet<Integer>> lru = new TreeMap<>();
    HashMap<Integer, Integer> cache = new HashMap<>();
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        
        int prevCnt = cnt.get(key), nowCnt = prevCnt + 1;
        cnt.put(key, nowCnt);
        
        lru.get(prevCnt).remove(key);
        if(lru.get(prevCnt).isEmpty()) lru.remove(prevCnt);
        
        if(!lru.containsKey(nowCnt)) lru.put(nowCnt, new LinkedHashSet<>());
        lru.get(nowCnt).add(key);
        
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(!cache.containsKey(key) && capacity == cache.size()) {
            int minCnt = lru.firstKey(), minKey = -1;
            var itr = lru.get(minCnt).iterator();

            if(itr.hasNext()) minKey = itr.next();
            
            cache.remove(minKey);
            lru.get(minCnt).remove(minKey);
            cnt.remove(minKey);
        }
        
        int prevCnt = cnt.getOrDefault(key, 0), nowCnt = prevCnt + 1;
        cache.put(key, value);
        cnt.put(key, nowCnt);
        
        if(lru.get(prevCnt) != null) {
            lru.get(prevCnt).remove(key);
            if(lru.get(prevCnt).isEmpty()) lru.remove(prevCnt);
        }
        
        if(!lru.containsKey(nowCnt)) lru.put(nowCnt, new LinkedHashSet<>());
        lru.get(nowCnt).add(key);
    }
}