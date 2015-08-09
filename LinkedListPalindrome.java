/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedListPalindrome {
   public static ListNode reverse(ListNode head)
   {
    ListNode prev = null;
    while(head!=null) 
    {
        ListNode tmp = head.next;
        head.next = prev;
        prev = head;
        head = tmp;
    }
    return prev;
    }

public boolean isPalindrome(ListNode head) {
    if (head==null) return true;
    
    ListNode fast = head.next;
    ListNode mid = head;
    
    while(fast !=null && fast.next != null) 
    {
        fast = fast.next.next;
        mid = mid.next;
    }

    ListNode tail = reverse(mid);

    while (tail !=null && head != null) 
    {
        if (tail.val != head.val) 
        {
            return false;
        }
        tail = tail.next;
        head = head.next;
    }
        return true;
    }
}
