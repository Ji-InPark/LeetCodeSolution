class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i < depth - 1; i++) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                TreeNode now = q.poll();
                
                if(now.left != null) q.add(now.left);
                
                if(now.right != null) q.add(now.right);
            }
        }
        
        int size = q.size();
        for(int i = 0; i < size; i++) {
            TreeNode now = q.poll();
            
            now.left = new TreeNode(val, now.left, null);
            
            now.right = new TreeNode(val, null, now.right);
        }
        
        return root;
    }
}