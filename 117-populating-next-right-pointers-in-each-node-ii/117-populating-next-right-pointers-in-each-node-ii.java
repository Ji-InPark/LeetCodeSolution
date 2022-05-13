class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                Node now = q.poll();
                
                now.next = i == size - 1 ? null : q.peek();
                
                if(now.left != null) q.add(now.left);
                if(now.right != null) q.add(now.right);
            }
        }
        
        return root;
    }
}