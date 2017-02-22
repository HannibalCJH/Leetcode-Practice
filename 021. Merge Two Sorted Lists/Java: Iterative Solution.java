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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val > l2.val)
            {
                pre.next = l2;
                l2 = l2.next;
            }
            else
            {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        
        while(l1 != null)
        {
            pre.next = l1;
            l1 = l1.next;
            pre = pre.next;
        }
        
        while(l2 != null)
        {
            pre.next = l2;
            l2 = l2.next;
            pre = pre.next;
        }
        
        return dummy.next;
    }
}
