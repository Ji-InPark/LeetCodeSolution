class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visit = new boolean[points.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        visit[0] = true;
        
        {
            int[] p1 = points[0];
            for(int j = 1; j < points.length; j++)
            {
                int[] p2 = points[j];
                
                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                
                pq.add(new Node(0, j, dist));
            }
        }
        
        int result = 0;
        int count = 1;
        
        while(true)
        {
            Node now = pq.poll();
            
            if(count == points.length) break;
            
            if(visit[now.i] && visit[now.j]) continue;
            
            if(!visit[now.i] && visit[now.j])
            {
                visit[now.i] = true;
                count++;
                
                for(int i = 0; i < points.length; i++)
                {
                    if(!visit[i]) 
                    {
                        int[] p1 = points[now.i], p2 = points[i];
                        
                        int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                        
                        pq.add(new Node(i, now.i, dist));
                    }
                }
            }
            else if(visit[now.i] && !visit[now.j])
            {
                visit[now.j] = true;
                count++;
                
                for(int i = 0; i < points.length; i++)
                {
                    if(!visit[i]) 
                    {
                        int[] p1 = points[now.j], p2 = points[i];
                        
                        int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                        
                        pq.add(new Node(i, now.j, dist));
                    }
                }
            }
            
            result += now.dist;
        }

        return result;
    }
}


class Node implements Comparable<Node>{
    int i, j;
    int dist;
    
    public Node(int i, int j, int dist)
    {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
    
    @Override
	public int compareTo(Node n) {
        return this.dist - n.dist;
	}
}

