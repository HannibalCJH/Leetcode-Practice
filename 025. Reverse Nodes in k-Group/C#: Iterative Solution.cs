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
        if(head == null || head.next == null || k == 1)
            return head;
            
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode beforeStart = dummy;
        int step = 0;
        while(head != null)
        {
            step++;
            if(step % k == 0)
            {
                beforeStart = Reverse(beforeStart, head.next);
                head = beforeStart.next;
            }
            else
                head = head.next;
        }
        return dummy.next;
    }
    
    private ListNode Reverse(ListNode beforeStart, ListNode afterEnd)
    {
        ListNode pre = beforeStart.next;
        ListNode cur = pre.next;
        ListNode firstToReverse = pre;
        while(cur != afterEnd)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        beforeStart.next = pre;
        firstToReverse.next = cur;
        return firstToReverse;
    }
}
