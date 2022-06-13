class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        
        for(int i = 1; i < triangle.size(); i++)
        {
            for(int j = 0; j < i + 1; j++)
            {
                if(j == 0)
                {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                }
                else if(j == i)
                {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                }
                else
                {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        
        int result = triangle.get(size - 1).get(0);
        for(int i = 1; i < size; i++)
        {
            result = Math.min(result, triangle.get(size - 1).get(i));
        }
        
        return result;
    }
}