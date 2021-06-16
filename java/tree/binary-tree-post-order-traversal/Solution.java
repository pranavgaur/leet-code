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
    public List<Integer> postorderTraversal(TreeNode root) {
//      Create a list to store the result
        List<Integer> list = new ArrayList<Integer>();

//      Call the driver function with root node and list
        list = driverFunction(root, list);

//      Return the list
        return list;

    }

    public List<Integer> driverFunction(TreeNode node, List<Integer> list){

//      Base condition check. If the node received is null, then,
//      return the existing list as it is
        if(node == null)
            return list;

//      1. Navigate to the left node
        list = driverFunction(node.left, list);

//      2. Navigate to the right node
        list = driverFunction(node.right, list);

//      3. Add the value to list
        list.add(node.val);

//      At the end of execution, return the final list
        return list;
    }
}