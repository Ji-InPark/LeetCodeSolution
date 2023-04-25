class SmallestInfiniteSet {
    TreeSet<Integer> set = new TreeSet<>();
    
    
    public SmallestInfiniteSet() {
        for(int i = 1; i <= 1000; i++) set.add(i);
    }
    
    public int popSmallest() {
        int result = set.first();
        
        set.remove(result);
        
        return result;
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}
