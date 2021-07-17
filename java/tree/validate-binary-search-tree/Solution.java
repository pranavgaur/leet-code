/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    boolean ans = true;
    
    List<Integer> list = new ArrayList<Integer>();
   
    public boolean isValidBST(TreeNode root) {
        traversal(root, root.val);
        return ans;
    }
    
    void traversal(TreeNode root, int prevValue) {
        
        if(root == null || !ans)
            return;
        
        traversal(root.left, root.val);
        
        if(list.size() == 0 || list.get(list.size()-1) < root.val)
            list.add(root.val);
        else
            ans = false;
        
        traversal(root.right, root.val);
        
    }
}