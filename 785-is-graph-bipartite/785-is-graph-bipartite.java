class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new  LinkedList<>();
        HashMap<Integer, Character> map = new HashMap<>();
        
        for(int a = 0; a < graph.length; a++)
        {
            if(graph[a].length > 0 && !map.containsKey(a))
            {
                q.add(a);
                
                char color = 'b';
        
                while(!q.isEmpty())
                {
                    int size = q.size();

                    color = color == 'b' ? 'r' : 'b';

                    for(int i = 0; i < size; i++)
                    {
                        int now = q.poll();

                        if(map.containsKey(now)) continue;

                        map.put(now, color);

                        for(int num : graph[now])
                        {
                            if(map.getOrDefault(num, 'n') != 'n')
                            {
                                if(map.get(num) == color) return false;
                            }
                            else
                            {
                                q.add(num);
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
}