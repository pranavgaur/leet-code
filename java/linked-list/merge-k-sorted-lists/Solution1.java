/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode resList = new ListNode();
        ListNode head = resList;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> {
           if(a.val>b.val)
               return 1;
            else if(a.val<b.val)
                return -1;
            return 0;
        });
        
        for(ListNode l1: lists){
            if(l1 != null)
                queue.add(l1);
            
        }
          
        while(!queue.isEmpty()){
            ListNode node1 = queue.poll();
            if(node1.next != null)
                queue.add(node1.next);
            node1.next = null;
            head.next = node1;
            head = head.next;
        }
        
        return resList.next;
    }
}