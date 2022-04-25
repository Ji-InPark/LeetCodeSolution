class PeekingIterator implements Iterator<Integer> {
    int save = 0;
    boolean isPeeked = false;
    Iterator<Integer> it;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    it = iterator;
	}

	public Integer peek() {
        if(isPeeked) return save;
        
        save = it.next();
        isPeeked = true;
        
        return save;
	}

	@Override
	public Integer next() {
	    if(isPeeked)
        {
            isPeeked = false;
            return save;
        }
        
        return it.next();
	}
	
	@Override
	public boolean hasNext() {
	    if(isPeeked) return true;
        
        return it.hasNext();
	}
}