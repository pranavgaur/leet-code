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
    boolean comparisonRes = true;
    boolean resp = false;
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        traverseTree(root, subRoot);
        return resp;
        
    }
    
    void traverseTree(TreeNode root, TreeNode subRoot){
        if(root != null){
            if(root.val == subRoot.val){
                comparisonRes = true;
                treeComparison(root, subRoot);
                if(comparisonRes == true)
                    resp = true;
                    
            }
            
            traverseTree(root.left, subRoot);
            traverseTree(root.right, subRoot);
        }
    }

    void treeComparison(TreeNode t1, TreeNode t2) {
        
        if(!comparisonRes || (t1==null && t2!=null) || (t1!=null && t2==null) || (t1!=null && t2!=null && t1.val != t2.val)){
            
            comparisonRes = false;
            
        } else{
            
            if(t1 != null && t2 != null){
                treeComparison(t1.left, t2.left);
                treeComparison(t1.right, t2.right);
            }
            
        }
        
    }
    
}