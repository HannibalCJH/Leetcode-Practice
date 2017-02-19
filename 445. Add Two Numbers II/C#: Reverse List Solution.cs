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
        l1 = ReverseList(l1);
        l2 = ReverseList(l2);
        
        ListNode head = AddListNumbers(l1, l2);
        return ReverseList(head);
    }
    
    private ListNode AddListNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int sum = 0, carry = 0;
        while(l1 != null || l2 != null)
        {
            if(l1 == null)
                l1 = new ListNode(0);
            if(l2 == null)
                l2 = new ListNode(0);
            
            sum = l1.val + l2.val + carry;
            ListNode cur = new ListNode(sum % 10);
            pre.next = cur;
            pre = cur;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
        }
        
        if(carry == 1)
            pre.next = new ListNode(1);
        return head.next;
    }
    
    private ListNode ReverseList(ListNode head)
    {
        if(head == null)
            return head;
            
        ListNode pre = head, cur = head.next;
        pre.next = null;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
