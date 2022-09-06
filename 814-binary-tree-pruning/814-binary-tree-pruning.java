class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(solve(root)) root = null;
        return root;
    }
    
    public boolean solve(TreeNode root) {
        boolean left = false, right = false, value = root.val == 0;
        
        if(root.left == null || root.left != null && solve(root.left)) {
            root.left = null;
            left = true;
        }
        
        if(root.right == null || root.right != null && solve(root.right)) {
            root.right = null;
            right = true;
        }
        
        return left && right && value;
    }
}