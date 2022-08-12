class Solution {
    Stack<TreeNode> s = new Stack<>();
    Stack<TreeNode> sp;
    Stack<TreeNode> sq;
    TreeNode p, q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        
        solve(root);
        
        while(sq.size() > sp.size()) sq.pop();
        while(sq.size() < sp.size()) sp.pop();
        
        while(sq.peek() != sp.peek()) {
            sq.pop();
            sp.pop();
        }
        
        return sp.pop();
    }
    
    public void solve(TreeNode root) {
        if(root == null || (sq != null && sp != null)) return;
        
        s.push(root);
        
        if(root == p) sp = (Stack<TreeNode>)s.clone();
        
        if(root == q) sq = (Stack<TreeNode>)s.clone();
        
        solve(root.left);
        
        solve(root.right);
        
        s.pop();
    }
}