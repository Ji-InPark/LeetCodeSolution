class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] arr = new TreeNode[1005];
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                TreeNode temp = q.poll();
                
                arr[temp.val] = temp;
                
                if(temp.left != null) q.add(temp.left);
                
                if(temp.right != null) q.add(temp.right);
            }
        }
        
        TreeNode start = null, node = null;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != null)
            {
                if(start == null) start = arr[i];
                if(node == null)
                {
                    node = arr[i];
                    node.left = null;
                    node.right = null;
                    continue;
                }
                
                node.right = arr[i];
                node = arr[i];
                node.right = null;
                node.left = null;
            }
        }
        
        return start;
    }
}