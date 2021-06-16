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
    public List<List<Integer>> levelOrder(TreeNode root) {

//      Create a variable for storing the final response list
        List<List<Integer>> list = new ArrayList<List<Integer>>();

//      Check if the tree is empty or not
        if(root == null)
            return list;

//      Create a queue for mantaining the level order values
        Queue<TreeNode> que = new LinkedList<TreeNode>();

//      Add the first element to the que
        que.add(root);

//      Iterate until the que is empty i.e. we reach the last child of the tree
        while(!que.isEmpty()){

//          Create a queue to mantian the children of the elements at current level
            Queue<TreeNode> que1 = new LinkedList<TreeNode>();

//          Create a list to store the values of the elements at current level
            List<Integer> list1 = new ArrayList<Integer>();

//          Iterate through all the elements in the que i.e. through all the
//          elements at current level
            while(!que.isEmpty()){
//              Add the value of elemeent to list and add their children to que1
                TreeNode node = que.poll();
                list1.add(node.val);
                if(node.left != null){
                    que1.add(node.left);
                }

                if(node.right != null){
                    que1.add(node.right);
                }
            }

//          Replace que with que1
            que = que1;

//          Add the current level values to final list
            list.add(list1);

        }

        return list;

    }
}