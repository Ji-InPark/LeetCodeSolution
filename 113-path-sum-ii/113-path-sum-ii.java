class Solution {
    Stack<Integer> s = new Stack<>();
    int targetSum;
    int sum = 0;
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root);
        return result;
    }
    
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        
        s.push(root.val);
        sum += s.peek();
        
        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                result.add(new ArrayList<>(s));
            }
            sum -= s.pop();
            return;
        }
        
        dfs(root.left);
        dfs(root.right);
        
        sum -= s.pop();
    }
}