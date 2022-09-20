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
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode third = null;
    
    TreeNode last = null;
    
    public void recoverTree(TreeNode root) {
        
        inorderTraversal(root);
       
        if(third != null) {
            
            int t = first.val;
            first.val = third.val;
            third.val = t;
            
        } else {
             int t = first.val;
            first.val = second.val;
            second.val = t;
        }
        
        
    }
    
    void inorderTraversal(TreeNode node) {
        
        if(node == null)
            return;
        
        inorderTraversal(node.left);
        
        if(last != null) {
            
            if(node.val < last.val){
                if(first == null && second == null) {
                    first = last;
                    second = node;
                } else {
                    third = node;
                }
            } 
            
        }
        
        last = node;
        
        inorderTraversal(node.right);
    }
}