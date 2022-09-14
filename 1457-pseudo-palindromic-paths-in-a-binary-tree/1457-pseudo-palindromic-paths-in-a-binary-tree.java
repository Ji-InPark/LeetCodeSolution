class Solution {
    int[] arr = new int[10];
    int size = 0;
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return result;
    }
    
    public void dfs(TreeNode root) {
        if(root == null) return;
        
        arr[root.val]++;
        size++;
        
        if(root.left == null && root.right == null) {
            if(checkPalindrome()) result++;
        }
        
        dfs(root.left);
        
        dfs(root.right);
        
        size--;
        arr[root.val]--;
    }
    
    public boolean checkPalindrome() {
        if(size % 2 == 0) {
            for(int num : arr) if(num % 2 == 1) return false;
        } else {
            boolean flag = false;
            for(int num : arr) {
                if(num % 2 == 1) {
                    if(!flag) {
                        flag = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}