class Solution {
    int result = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root != null) solve(root, 0);

        return result;
    }
    
    private void solve(TreeNode root, int num) {
        if(root.left == null && root.right == null) {
            result += num * 10 + root.val;
            return;
        }
        
        if(root.left != null) solve(root.left, num * 10 + root.val);
        if(root.right != null) solve(root.right, num * 10 + root.val);
    }
}