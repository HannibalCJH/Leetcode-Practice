/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) 
    {
        return Helper(l1, l2, 0);
    }
    
    private ListNode Helper(ListNode l1, ListNode l2, int carry)
    {
        if(l1 == null && l2 == null)
            return carry == 0 ? null : new ListNode(1);
        
        if(l1 == null && l2 != null)
            l1 = new ListNode(0);
        if(l1 != null && l2 == null)
            l2 = new ListNode(0);
            
        int sum = l1.val + l2.val + carry;
        ListNode cur = new ListNode(sum % 10);
        cur.next = Helper(l1.next, l2.next, sum / 10);
        return cur;
    }
}
