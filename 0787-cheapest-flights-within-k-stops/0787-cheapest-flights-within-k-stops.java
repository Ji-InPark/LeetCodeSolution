class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, Integer>[] arr = new HashMap[n];
        var v = new int[n];
        int result = Integer.MAX_VALUE;
        
        Arrays.fill(v, Integer.MAX_VALUE);
        
        for(var f : flights) {
            if(arr[f[0]] == null) arr[f[0]] = new HashMap<>();
            
            arr[f[0]].put(f[1], f[2]);
        }
        
        var q = new LinkedList<int[]>();
        q.add(new int[]{src, 0});
        
        for(int i = 0; i <= k + 1; i++) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                var now = q.poll();
                
                if(now[1] > result || v[now[0]] < now[1]) continue;
                if(now[0] == dst) {
                    result = Math.min(result, now[1]);
                    continue;
                }
                if(arr[now[0]] == null) continue;
                
                v[now[0]] = now[1];
                
                for(var key: arr[now[0]].keySet()) q.add(new int[] {key, arr[now[0]].get(key) + now[1]});
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}