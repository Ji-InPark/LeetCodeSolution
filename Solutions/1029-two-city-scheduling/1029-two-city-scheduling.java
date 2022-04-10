class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int result = 0;
        
        Arrays.sort(costs, (o1, o2) ->{return (o1[0] - o1[1]) - (o2[0] - o2[1]);});
        
        for(int i = 0; i < costs.length; i++) result += costs[i][i / n];
        
        return result;
    }
}