class Solution {
    public boolean isCompleteTree(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);
        var emptyOccurred = false;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                var now = q.poll();
                
                if(now == null) {
                    emptyOccurred = true;
                    continue;
                } 
                
                if(emptyOccurred) return false;
                
                q.add(now.left);
                q.add(now.right);
            }
        }
        
        return true;
    }
}