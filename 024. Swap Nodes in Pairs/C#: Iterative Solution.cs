/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode SwapPairs(ListNode head) 
    {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while(cur != null && cur.next != null)
        {
            ListNode next = cur.next;
            cur.next = next.next;
            pre.next = next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
