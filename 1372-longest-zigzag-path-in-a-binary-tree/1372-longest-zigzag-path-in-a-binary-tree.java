class Solution {
    int result = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return result;
        
        solve(root.left, true, 1);
        solve(root.right, false, 1);
        
        return result;
    }
    
    private void solve(TreeNode root, boolean isLeft, int length) {
        if(root == null) return;
        
        result = Math.max(result, length);
        
        solve(root.left, true, !isLeft ? length + 1 : 1);
        solve(root.right, false, isLeft ? length + 1 : 1);
    }
}