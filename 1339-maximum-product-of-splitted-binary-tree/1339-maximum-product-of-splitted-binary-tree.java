class Solution {
    final int mod = 1000000007;
    long result = 0;
    int sum = 0;
    public int maxProduct(TreeNode root) {
        sum = setSum(root);
        
        var q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()) {
            var size = q.size();
            
            for(int i = 0; i < size; i++) {
                var now = q.poll();
                if(now == null) continue;
                
                result = Math.max(result, (long)now.val * (long)(sum - now.val));
                
                q.add(now.left);
                q.add(now.right);
            }
        }
        
        return (int)(result % mod);
    }
    
    public int setSum(TreeNode root) {
        if(root == null) return 0;
        
        root.val += setSum(root.left) + setSum(root.right);
        
        return root.val;
    }
}