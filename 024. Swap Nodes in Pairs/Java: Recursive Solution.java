/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        // 下一个节点
        ListNode next = head.next;
        // 注意我们传入的是下下个节点
        head.next = swapPairs(next.next);
        // 下个节点指向当前节点
        next.next = head;
        return next;
    }
}
