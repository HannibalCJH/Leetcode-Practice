/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 迭代法，也是把空的节点更新为0节点
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode pt1 = l1, pt2 = l2;
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        int carry = 0, sum = 0;
        while(pt1 != null || pt2 != null)
        {
            if(pt1 == null)
                pt1 = new ListNode(0);
            if(pt2 == null)
                pt2 = new ListNode(0);
            sum = pt1.val + pt2.val + carry;
            ListNode cur = new ListNode(sum % 10);
            pre.next = cur;
            pre = cur;
            pt1 = pt1.next;
            pt2 = pt2.next;
            carry = sum / 10;
        }
        
        if(carry == 1)
            pre.next = new ListNode(1);
        return head.next;
    }
}
