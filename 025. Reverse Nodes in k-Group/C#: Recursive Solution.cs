/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode ReverseKGroup(ListNode head, int k) 
    {
        if(head == null || head.next == null)
            return head;
        
        int count = 0;
        ListNode cur = head;
        while(cur != null && count < k)
        {
            cur = cur.next;
            count++;
        }
        
        if(count == k)
        {
            cur = ReverseKGroup(cur, k);
            while(count-- > 0)
            {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }
}
