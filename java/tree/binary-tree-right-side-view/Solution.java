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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList();
        if(root == null)
            return res;
        
        res = levelOrderTraversal(root);
        return res;
            
    }
    
    List<Integer> levelOrderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList();
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int lastNode = 0;
            Queue<TreeNode> queue1 = new LinkedList();
            
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                lastNode = node.val;
                
                if(node.left != null)
                    queue1.add(node.left);
                
                if(node.right != null)
                    queue1.add(node.right);
                
            }
            
            list.add(lastNode);
            queue = queue1;
        }
        
        return list;
    }
}