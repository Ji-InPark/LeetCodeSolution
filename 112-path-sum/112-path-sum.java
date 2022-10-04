class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode now = q.poll();
                
                if(isLeaf(now) && now.val == targetSum) return true;
                
                if(now.left != null) {
                    now.left.val += now.val;
                    q.add(now.left);
                }
                
                if(now.right != null) {
                    now.right.val += now.val;
                    q.add(now.right);
                }
            }
        }
        
        return false;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}