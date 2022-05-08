public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> arr = new ArrayList<>();
    List<NestedInteger> nestedList;
    
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        AddAll();
    }

    @Override
    public Integer next() {
        return arr.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < arr.size();
    }
    
    public void AddAll()
    {
        for(int i = 0; i < nestedList.size(); i++)
        {
            Add(nestedList.get(i));
        }
    }
    
    public void Add(NestedInteger ni)
    {
        if(ni.isInteger())
        {
            arr.add(ni.getInteger());
        }
        else
        {
            for(int i = 0; i < ni.getList().size(); i++)
            {
                Add(ni.getList().get(i));
            }
        }
    }
}
