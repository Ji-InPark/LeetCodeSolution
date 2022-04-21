class MyHashSet {
    HashMap<Integer, Boolean> map = new HashMap<>();
    
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        map.put(key, true);
    }
    
    public void remove(int key) {
        map.remove(key);
    }
    
    public boolean contains(int key) {
        return map.getOrDefault(key, false);
    }
}
