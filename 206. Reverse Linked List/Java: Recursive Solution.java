/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public ListNode reverseList(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        
        // 下一个节点
        ListNode next = head.next;
        // 把当前节点指向空
        head.next = null;
        // 最后的节点就是root，每次return的都是最后的那个节点
        ListNode root = reverseList(next);
        // 下一个节点指向当前节点
        next.next = head;
        return root;
    }
}
