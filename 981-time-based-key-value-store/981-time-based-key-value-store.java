class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        
        Integer floorKey = map.get(key).floorKey(timestamp);
        
        if(floorKey == null) return "";
        
        return map.get(key).get(floorKey);
    }
}
