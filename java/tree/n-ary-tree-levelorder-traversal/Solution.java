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
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> list = new ArrayList();

        if(root == null)
            return list;

        list = driverFunction(root);
        return list;

    }

    List<List<Integer>> driverFunction(Node root) {

        List<List<Integer>> list = new ArrayList();
        Queue<Node> que = new LinkedList();

        que.add(root);

        while(!que.isEmpty()){
            Queue<Node> que1 = new LinkedList();
            List<Integer> list1 = new ArrayList();

            while(!que.isEmpty()){
                Node node1 = que.poll();
                list1.add(node1.val);
                for(Node child: node1.children){
                    que1.add(child);
                }
            }
            list.add(list1);
            que = que1;

        }

        return list;
    }
}