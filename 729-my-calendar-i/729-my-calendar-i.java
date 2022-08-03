class MyCalendar {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        int s = -1, e = -1;
        if(map.floorKey(start) != null) {
            s = map.floorKey(start);
        }
        
        if(map.floorKey(--end) != null) {
            e = map.floorKey(end);
        }
        
        if(s - e != 0) return false;
        
        if(s != -1 && start <= map.get(s)) return false;
        
        map.put(start, end);
        
        return true;
    }
}
