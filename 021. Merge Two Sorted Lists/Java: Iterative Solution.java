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
    // 时间复杂度O(min(m, n))，只需遍历完短的链表，然后把长链表余下的直接接到结果后面
    // 空间复杂度O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                pre.next = l1;
                l1 = l1.next;
            }
            else
            {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        // 直接把剩下没遍历完的那个链表接上就行，因为本来链表就是排序过的
        if(l1 != null)
            pre.next = l1;
        if(l2 != null)
            pre.next = l2;
            
        return dummy.next;
    }
}
