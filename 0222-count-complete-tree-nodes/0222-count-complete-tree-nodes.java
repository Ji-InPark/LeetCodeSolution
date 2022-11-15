class Solution {
    public int countNodes(TreeNode root) {
        int left = leftHeight(root);
        int right = rightHeight(root);
        
        if(left == right) return (1 << left) - 1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int leftHeight(TreeNode root) {
        int depth = 0;
        while(root != null) {
            depth++;
            root = root.left;
        }
        
        return depth;
    }
    
    public int rightHeight(TreeNode root) {
        int depth = 0;
        while(root != null) {
            depth++;
            root = root.right;
        }
        
        return depth;
    }
}