/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode MergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.Length == 0)
            return null;
            
        return DivAndConq(lists, 0, lists.Length - 1);
    }
    
    private ListNode DivAndConq(ListNode[] lists, int left, int right)
    {
        if(left == right)
            return lists[left];
        
        int mid = left + (right - left) / 2;
        ListNode l1 = DivAndConq(lists, left, mid);
        ListNode l2 = DivAndConq(lists, mid + 1, right);
        
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
        
        if(l1 != null)
            pre.next = l1;
        if(l2 != null)
            pre.next = l2;
            
        return dummy.next;
    }
}
