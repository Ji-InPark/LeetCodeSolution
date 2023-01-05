class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : (a[0] < b[0] ? -1 : 1));
        int result = 1, left = points[0][0], right = points[0][1];
        
        for(int i = 1; i < points.length; i++) {
            var p = points[i];
            if(right < p[0]) {
                result++;
                right = p[1];
            } else {
                left = p[0];
                right = Math.min(p[1], right);
            }
        }
        
        return result;
    }
}