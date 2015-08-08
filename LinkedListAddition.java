/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedListAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long multiply = 1; 
        long sum_one = 0; 
        while(l1 != null)
        {
            sum_one += multiply * l1.val; 
            multiply *= 10; 
            l1 = l1.next; 
        }
        multiply = 1; 
        long sum_two = 0; 
        while(l2 != null)
        {
            sum_two += multiply * l2.val; 
            multiply *= 10; 
            l2 = l2.next; 
        }
        
        String num = Long.toString(sum_one+sum_two); 
        ListNode head = new ListNode(Character.getNumericValue(num.charAt(num.length()-1)));
        ListNode curr = head; 
        for(int i = num.length()-2; i >= 0; --i)
        {
            curr.next = new ListNode(Character.getNumericValue(num.charAt(i)));
            curr = curr.next;
        }
        return head; 
    }
}
