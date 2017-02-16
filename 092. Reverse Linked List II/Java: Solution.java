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
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
        if(head == null || head.next == null || m == n)
            return head;
        ListNode dummy = new ListNode(-1);
        // 伪表头
        dummy.next = head;
        head = dummy;
        // 前进m-1步，head指向将要反转的第一个节点的前置节点
        for(int i = 0; i < m - 1; i++)
            head = head.next;
        // pre为要反转的第一个节点
        ListNode pre = head.next, cur = pre.next;
        // start保存要反转的第一个节点
        ListNode start = pre;
        ListNode next;
        // 反转链表
        for(int i = 0; i < n - m; i++)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 反转后进行的处理
        // 1. head是原来要反转的第一个节点的前置节点，现在应该指向反转以后第一个节点即原来要反转的最后一个节点
        // 2. 原来链表中第一个要反转的节点成了反转以后最后一个节点，它应该要指向原来最后要反转节点的后一个节点
        head.next = pre;
        start.next = cur;
        return dummy.next;
    }
}
