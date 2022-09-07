class Solution {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        solve(root);
        return sb.toString();
    }
    
    public void solve(TreeNode root) {
        if(root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        sb.append(root.val + "(");
        if(root.left != null) solve(root.left);
        sb.append(")");
        if(root.right != null) {
            sb.append("(");
            solve(root.right);
            sb.append(")");
        }
    }
}