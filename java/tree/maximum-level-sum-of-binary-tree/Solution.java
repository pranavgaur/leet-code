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
    
    Queue<TreeNode> que = new LinkedList<TreeNode>();
    
    public int maxLevelSum(TreeNode root) {
        
        que.add(root);
        que.add(null);
        int maxSum = root.val;
        int currentMax = 0;
        int index = 2;
        int res = 1;
        
        while(!que.isEmpty()){
            
            TreeNode node = que.poll();
            
            if(node == null ){
                
                if(!que.isEmpty()){
                    if(currentMax > maxSum && !que.isEmpty()){
                        res = index;
                        maxSum = currentMax;
                    }
                    currentMax = 0;
                    index++;
                    que.add(null);
                }
                    
            } else {
                if(node.left != null){
                    que.add(node.left);
                    currentMax += node.left.val; 
                }

                if(node.right != null){
                    que.add(node.right);
                    currentMax += node.right.val; 
                }
            }
             
        }
        
        return res;
        
    }
}