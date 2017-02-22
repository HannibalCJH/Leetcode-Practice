/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 分治法
    // 时间复杂度O(nlogk)，n为所有节点，k为链表的个数
    // 空间复杂度O(logk)
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.length == 0)
            return null;
        return divAndConq(lists, 0, lists.length - 1);
    }
    
    private ListNode divAndConq(ListNode[] lists, int left, int right)
    {
        // 不能再分，返回唯一的链表
        if(left == right)
            return lists[left];
        // 把链表从中间分开，各自往下继续分，直到left == right为止
        int mid = left + (right - left) / 2;
        ListNode l1 = divAndConq(lists, left, mid);
        ListNode l2 = divAndConq(lists, mid + 1, right);
        // 对左右两边得到的归并好的链表进行再一次归并，参考merge two sorted lists
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
