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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // List to store the result
        ListNode resL = null;
        
        // Variable to store the carried upon value
        int carry = 0;
        
        // Variable to store the two digits to add
        int first = 0;
        int second =0;
        
        // Iterate through the lists, until each of them exhausts &
        // also the value of carry variable is 0
        while (l1 != null || l2!=null || carry!=0){
            
            // first digit = val of current pointer on list 1 or 0 if null
            first = l1 != null ? l1.val : 0;
            // second digit = val of current pointer on list 2 or 0 if null
            second = l2 != null ? l2.val : 0;
            
            // add the two digits and also the carried upon value
            int sum = first+second+carry;
            
            // revise the carry and sum values
            carry = sum/10;
            sum = sum%10;
            
            // create a node for new sum
            ListNode node = new ListNode(sum, null);
           
            // add the new node to the end of the resultant list
            if(resL == null)
                resL = node;
            else{
                ListNode temp = resL;
            
                while(temp.next!=null){
                    temp = temp.next;
                }
                
                temp.next = node;
            }
            
            // move ahead the pointers in each list if not null
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            
        }
        
        return resL;
        
    }
}