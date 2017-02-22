/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 递归法
    // 时间复杂度O(min(m, n))，当一个链表已经遍历完了，直接把另外的剩余链表整个接到最终链表后面不用再往下找，因为本来链表就是排序过的
    // 空间复杂度O(min(m, n))
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        // 当一个链表遍历完，直接返回另一个余下的所有节点，因为链表本来就是排序过，后面不用再比较了
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        ListNode mergeHead;
        if(l1.val < l2.val)
        {
            mergeHead = l1;
            l1 = l1.next;
        }
        else
        {
            mergeHead = l2;
            l2 = l2.next;
        }
        
        mergeHead.next = mergeTwoLists(l1, l2);
        
        return mergeHead;
    }
}
