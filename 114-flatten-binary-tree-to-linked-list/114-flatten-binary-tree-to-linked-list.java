class Solution {
    ArrayList<TreeNode> arr = new ArrayList<>();
    public void flatten(TreeNode root) {
        solve(root);
        
        for(int i = 0; i < arr.size() - 1; i++) {
            TreeNode now = arr.get(i);
            now.left = null;
            now.right = arr.get(i + 1);
        }
        
        if(arr.size() > 0) {
            TreeNode now = arr.get(arr.size() - 1);
            now.left = null;
            now.right = null;
        }
    }
    
    public void solve(TreeNode root) {
        if(root == null) return;
        
        arr.add(root);
        
        solve(root.left);
        solve(root.right);
    }
}