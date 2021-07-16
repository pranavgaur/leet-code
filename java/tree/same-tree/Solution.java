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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        compareTrees(p, q);
        return ans;
        
    }
    
    public void compareTrees(TreeNode t1, TreeNode t2){
        
        if(!ans || (t1 == null && t2 != null) || (t1 != null && t2 == null) || (t1!=null && t2!=null && t1.val!=t2.val)){
            ans=false;
        }else{
            if(t1!=null && t2!=null){
                compareTrees(t1.left, t2.left);
                compareTrees(t1.right, t2.right);
            }
        }
    }
}