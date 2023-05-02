class SnapshotArray {
    int id = 0;
    HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    
    public SnapshotArray(int length) {

    }
    
    public void set(int index, int val) {
        if(!map.containsKey(index)) map.put(index, new TreeMap<>());
        map.get(index).put(id, val);
    }
    
    public int snap() {
        return id++;
    }
    
    public int get(int index, int snap_id) {
        if(!map.containsKey(index)) return 0;
        
        var key = map.get(index).floorKey(snap_id);
        
        if(key == null) return 0;
        
        return map.get(index).get(key);
    }
}
