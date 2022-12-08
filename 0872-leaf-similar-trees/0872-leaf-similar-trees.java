class Solution {
    Queue<TreeNode> q = new LinkedList<>();
    boolean result = true;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs1(root1);
        dfs2(root2);
        return result && q.isEmpty();
    }
    
    public void dfs1(TreeNode root) {
        if(root == null) return;
        
        if(isLeaf(root)) {
            q.add(root);
            return;
        }
        
        dfs1(root.left);
        dfs1(root.right);
    }
    
    public void dfs2(TreeNode root) {
        if(root == null || !result) return;
        
        if(isLeaf(root)) {
            if(q.isEmpty() || q.poll().val != root.val) result = false;
            return;
        }
        
        dfs2(root.left);
        dfs2(root.right);
    }
    
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
}