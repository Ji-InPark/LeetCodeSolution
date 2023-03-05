class Solution {
    public int minJumps(int[] arr) {
        var visit = new boolean[arr.length];
        var map = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i < arr.length; i++) {
            var num = arr[i];
            if(!map.containsKey(num)) map.put(num, new ArrayList<>());
            map.get(num).add(i);
        }
        
        var q = new LinkedList<Integer>();
        q.add(0);
        
        for(int jump = 0; jump < arr.length; jump++) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                var now = q.poll();
                
                if(now == arr.length - 1) return jump;
                
                if(now - 1 > 0 && !visit[now - 1]) q.add(now - 1);
                if(!visit[now + 1]) q.add(now + 1);
                
                if(visit[now]) continue;
                
                visit[now] = true;
                
                for(var index: map.get(arr[now])) {
                    if(visit[index]) continue;
                    visit[index] = true;
                    q.add(index);
                }
            }
        }
        
        return arr.length - 1;
    }
}