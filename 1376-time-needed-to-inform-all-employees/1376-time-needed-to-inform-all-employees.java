class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] times;
    int result = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n == 1) return 0;
        
        times = informTime;
        
        for(int i = 0; i < manager.length; i++) {
            int m = manager[i];
            if(m == -1) continue;
            
            if(!map.containsKey(m)) map.put(m, new ArrayList<>());
            map.get(m).add(i);
        }
        
        dfs(headID, times[headID]);
        
        return result;
    }
    
    private void dfs(int node, int time) {
        if(!map.containsKey(node)) {
            result = Math.max(result, time);
            return;
        }
        
        for(var emp: map.get(node)) dfs(emp, time + times[emp]);
    }
}