/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {

//      Create a list to store the result
        List<Integer> list = new ArrayList<Integer>();

//      Call the driver function with root node and list
        list = driverFunction(root, list);

//      Return the list
        return list;

    }

    public List<Integer> driverFunction(Node node, List<Integer> list){

//      Base condition check. If the node received is null, then,
//      return the existing list as it is
        if(node == null)
            return list;

//      1. Navigate to each child from left to right
        for(Node child: node.children){
            list = driverFunction(child, list);
        }

//      2. Add the value to list
        list.add(node.val);

        return list;
    }
}