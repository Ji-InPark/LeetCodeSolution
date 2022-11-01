class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        
        for(int ball = 0; ball < result.length; ball++) {
            int location = ball;
            for(int i = 0; i < grid.length; i++) {
                if(grid[i][location] == 1) {
                    if(location + 1 >= result.length || grid[i][location + 1] == -1){
                        location = -1;
                        break;
                    }
                    location++;
                } else {
                    if(location - 1 < 0 || grid[i][location - 1] == 1){
                        location = -1;
                        break;
                    }
                    location--;
                }
            }
            result[ball] = location;
        }
        
        return result;
    }
}