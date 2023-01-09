class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    
    public void dfs(TreeNode root) {
        if(root == null) return;
        result.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}