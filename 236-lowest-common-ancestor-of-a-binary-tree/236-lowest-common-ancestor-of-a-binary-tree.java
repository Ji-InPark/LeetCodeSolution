/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode p, q;
    ArrayList<TreeNode> pal, qal;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        solve(root, new Stack<>());
        
        TreeNode result = root;
        
        try{
            int index = 0;
            while(pal.get(index) == qal.get(index)) {
                result = pal.get(index++);
            }
        } catch(Exception e) {
            
        }
        
        return result;
    }
    
    public void solve(TreeNode node, Stack<TreeNode> s) {
        if(pal != null && qal != null) return;
        
        s.push(node);
        
        if(node == p) {
            pal = new ArrayList(s);
        }
        if(node == q) {
            qal = new ArrayList(s);
        }
        
        if(node.left != null) solve(node.left, s);
        if(node.right != null) solve(node.right, s);
        
        s.pop();
    }
}
