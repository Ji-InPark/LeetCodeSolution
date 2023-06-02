class Solution {
    public int minFallingPathSum(int[][] grid) {
        var map = new TreeMap<Integer, ArrayList<Integer>>();
        int n = grid.length;
        
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(grid[0][i])) map.put(grid[0][i], new ArrayList<>());
            map.get(grid[0][i]).add(i);
        }
        
        for(int i = 1; i < n; i++) {
            var firstKey = map.firstKey();
            var secondKey = map.higherKey(firstKey);
            
            var firstIndex = map.get(firstKey).get(0);
            var secondIndex = (secondKey == null || map.get(firstKey).size() > 1) ? firstIndex : map.get(secondKey).get(0);
            
            grid[i][firstIndex] += grid[i - 1][secondIndex];
            
            for(int j = 0; j < n; j++) {
                if(j == firstIndex) continue;
                
                grid[i][j] += grid[i - 1][firstIndex];
            }
            
            map.clear();
            
            for(int j = 0; j < n; j++) {
                if(!map.containsKey(grid[i][j])) map.put(grid[i][j], new ArrayList<>());
                map.get(grid[i][j]).add(j);
            }
        }
        
        int result = grid[n - 1][0];
        for(int i = 1; i < n; i++) result = Math.min(result, grid[n - 1][i]);
        
        return result;
    }
}
