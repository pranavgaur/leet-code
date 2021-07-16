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

    int maxLen = 0;
    
    public int longestConsecutive(TreeNode root) {

        if(root != null)
            longestConsecutive(root, 0, root.val);
            
        if(maxLen==1)
            return -1;
        
        return maxLen;
            
    }
        
    void longestConsecutive(TreeNode root, int currentLen, int targetValue) {

        if(root != null){
            if(root.val == targetValue){
                currentLen++;
                targetValue++;
            } else {
                currentLen = 1;
                targetValue = root.val + 1;
            }
            maxLen = Math.max(maxLen, currentLen);
            longestConsecutive(root.left, currentLen, targetValue);
            longestConsecutive(root.right, currentLen, targetValue);
            
        }
         
    }

}