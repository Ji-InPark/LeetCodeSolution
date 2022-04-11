class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) result.add(new ArrayList<>());
        
        int index = 0;
        
        k %= grid.length * grid[0].length;
        
        for(int i = grid.length * grid[0].length - k; i < grid.length * grid[0].length * 2 - k; i++)
        {
            int temp = i % (grid.length * grid[0].length);
            int y = temp / grid[0].length, x = temp % grid[0].length;
            
            if(result.get(index).size() == grid[0].length) index++;
            
            result.get(index).add(grid[y][x]);
        }
        
        return result;
    }
}