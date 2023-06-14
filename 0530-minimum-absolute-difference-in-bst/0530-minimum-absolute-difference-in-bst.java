class Solution {
    int result = 100000;
    TreeSet<Integer> set = new TreeSet<>();
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return result;
        
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        
        var floor = set.floor(root.val);
        var ceiling = set.ceiling(root.val);
        
        if(floor != null) result = Math.min(result, root.val - floor);
        if(ceiling != null) result = Math.min(result, ceiling - root.val);
        
        set.add(root.val);
        
        return result;
    }
}