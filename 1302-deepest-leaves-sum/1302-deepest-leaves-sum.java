class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int result = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            result = 0;
            
            for(int i = 0; i < size; i++)
            {
                TreeNode now = q.poll();
                
                result += now.val;
                
                if(now.left != null) q.add(now.left);
                if(now.right != null) q.add(now.right);
            }
        }
        
        return result;
    }
}