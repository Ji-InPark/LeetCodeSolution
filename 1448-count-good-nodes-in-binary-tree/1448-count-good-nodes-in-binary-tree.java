class Solution {
    Stack<Integer> s = new Stack<>();
    int result = 0;
    public int goodNodes(TreeNode root) {
        s.push(-10005);
        dfs(root);
        return result;
    }
    
    public void dfs(TreeNode root) {
        if(root == null) return;
        
        if(s.peek() <= root.val) result++;
        
        s.push(Math.max(s.peek(), root.val));
        
        dfs(root.left);
        
        dfs(root.right);
        
        s.pop();
    }
}