class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        var inc = (double)(coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        
        for(int i = 2; i < coordinates.length; i++) 
            if((double)(coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0]) != inc) return false;
        
        return true;
    }
}