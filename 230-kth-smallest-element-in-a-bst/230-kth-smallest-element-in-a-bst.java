class Solution {
    int num;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        solve(root);
        
        return result.val;
    }
    
    public void solve(TreeNode root)
    {
        if(root == null || result != null) return;
        
        solve(root.left);
        
        num--;
        
        if(num == 0) result = root;
        
        solve(root.right);
    }
}