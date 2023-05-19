class Solution {
    public boolean isBipartite(int[][] graph) {
        var arr = new Boolean[graph.length];
        var visit = new boolean[graph.length];
        var q = new LinkedList<Integer>();
        
        for(int i = 0; i < graph.length; i++) {
            if(arr[i] != null) continue;
            q.add(i);
            arr[i] = true;
            
            while(!q.isEmpty()) {
                var now = q.poll();

                if(visit[now]) continue;

                visit[now] = true;

                for(var child: graph[now]) {
                    if(arr[child] == null) arr[child] = !arr[now];
                    else if(arr[child] == arr[now]) return false;

                    q.add(child);
                }
            }
        }
        
        return true;
    }
}