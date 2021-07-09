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

class Record {
    int row;
    int col;
    TreeNode node;
    
    Record(int row, int col, TreeNode node){
        this.row = row;
        this.col = col;
        this.node = node;
    }
}

class MyComparator implements Comparator<Record> {
    
    public int compare(Record r1, Record r2){
        if(r1.col == r2.col){
            if(r1.row == r2.row){
                return r1.node.val-r2.node.val;
            } else {
                return r1.row-r2.row;
            } 
        } else {
            return r1.col-r2.col;
        }
        
    }
}

class Solution {
    
    PriorityQueue<Record> que = new PriorityQueue(new MyComparator());
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> resList = new ArrayList();
        
        runner(0,0,root);
        
        int index = -1;
        int prevCol = que.size();
        
        while(!que.isEmpty()){
            Record r = que.poll();
            int curCol = r.col;
            
            if(prevCol != curCol){
                resList.add(new ArrayList());
                index++;
                prevCol = curCol;
            } 
            resList.get(index).add(r.node.val);
            
        }
        
        return resList;
        
    }
    
    void runner(int row, int col, TreeNode node) {
        
        if(node != null){
            que.add(new Record(row, col, node));
            runner(row+1, col-1, node.left);
            runner(row+1, col+1, node.right);
        }
        
    }
}