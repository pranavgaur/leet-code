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
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return false;
        
        driverFunction(root, targetSum);
        return ans;
        
    }
    
    public void driverFunction(TreeNode root, int target) {
        
        target = target - root.val;
        
        if(target == 0 && root.left == null && root.right == null)
            ans = true;
        
        if(root.left != null) {
            driverFunction(root.left, target);
        }
        
        if(root.right != null) {
            driverFunction(root.right, target);
        }
            
    }
}