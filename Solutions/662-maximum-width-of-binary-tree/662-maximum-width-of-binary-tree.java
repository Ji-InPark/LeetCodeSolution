class Solution {
    int result = 0;
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        root.val = 1;
        q.add(root);
        
        bfs(q);

        
        return result;
    }
    
    public void bfs(Queue<TreeNode> q)
    {
        if(q.isEmpty())
            return;
        
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        
        int first = 0, last = 0;
        
        for(int i = 0; !q.isEmpty(); i += 2)
        {
            TreeNode temp = q.poll();
            if(temp == null) continue;
            
            if(temp.left != null)
            {
                temp.left.val = temp.val * 2;
                if(first == 0)
                    first = temp.left.val;
                last = temp.left.val;
            }
            if(temp.right != null)
            {   
                temp.right.val = temp.val * 2 + 1;
                if(first == 0)
                    first = temp.right.val;
                last = temp.right.val;
            }
            
            result = Math.max(result, last - first + 1);

            next.add(temp.left);
            next.add(temp.right);
        }
        
        bfs(next);
    }
}