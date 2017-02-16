/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 迭代法
    // 时间复杂度O(n)，空间复杂度O(1)
    public ListNode reverseList(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
            
        ListNode pre = head, cur = head.next;
        ListNode next;
        pre.next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
