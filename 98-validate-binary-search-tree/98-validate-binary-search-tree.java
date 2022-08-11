class Solution {
    int pre = -1;
    boolean hasPre = false;
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        solve(root);
        return result;
    }
    
    public void solve(TreeNode root) {
        if(root == null) return;
        
        solve(root.left);
        if(hasPre && pre >= root.val) result = false;
        hasPre = true;
        pre = root.val;
        solve(root.right);
    }
}