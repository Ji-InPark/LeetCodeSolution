class BSTIterator {
    Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    
    public void dfs(TreeNode root)
    {
        if(root == null) return;
        
        s.push(root);
        dfs(root.left);
    }
    
    public int next() {
        TreeNode now = s.pop();
        dfs(now.right);
        
        return now.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}