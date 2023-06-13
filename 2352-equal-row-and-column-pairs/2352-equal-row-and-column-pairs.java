class Solution {
    public int equalPairs(int[][] grid) {
        var map = new HashMap<String, Integer>();
        
        for(var row: grid) {
            var sb = new StringBuilder();
            for(var c: row) sb.append(c + "-");
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            var sb = new StringBuilder();
            for(int j = 0; j < grid.length; j++) sb.append(grid[j][i] + "-");
            result += map.getOrDefault(sb.toString(), 0);
        }
        
        return result;
    }
}