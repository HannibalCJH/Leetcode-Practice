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
        // 记得把头指针的next指向空不然会形成环
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
