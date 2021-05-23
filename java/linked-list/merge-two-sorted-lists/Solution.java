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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode resList = new ListNode(0,null);
        ListNode pointer = resList;
        
        while(l1 !=null && l2 != null){
            
            ListNode temp = null;
            if(l1.val <= l2.val){
                temp = new ListNode(l1.val, null);
                l1 = l1.next;
            } else if(l2.val < l1.val){
                temp = new ListNode(l2.val, null);
                l2 = l2.next;
            }
        
            pointer.next = temp;
            pointer = pointer.next;

        }
        
        while(l1!=null){
            ListNode temp = new ListNode(l1.val, null);
            pointer.next = temp;
            l1 = l1.next;
            pointer = pointer.next;
        }
        
        while(l2!=null){
            ListNode temp = new ListNode(l2.val, null);
            pointer.next = temp;
            l2 = l2.next;
            pointer = pointer.next;
        }        
        
        return resList.next;
        
    }
}