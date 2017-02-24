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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head == null || head.next == null || k == 1)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 需要反转的第一个节点的前驱节点
        ListNode beforeStart = dummy;
        // 记录走过的链表的步长
        int step = 0;
        while(head != null)
        {
            step++;
            // 走过的步长是k的整数倍，需要反转一组节点
            if(step % k == 0)
            {
                beforeStart = reverse(beforeStart, head.next);
                head = beforeStart.next;
            }
            else
                // 不是整数倍，继续往前走
                head = head.next;
        }
        return dummy.next;
    }
    
    // beforeStart为需要反转的第一个节点的前驱节点，afterEnd是需要反转的最后一个节点的下一个节点
    // 这两个节点都不在这次反转的节点之中
    private ListNode reverse(ListNode beforeStart, ListNode afterEnd)
    {
        ListNode pre = beforeStart.next;
        ListNode cur = pre.next;
        // 需要反转的第一个节点
        ListNode firstToReverse = pre;
        while(cur != afterEnd)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 前驱节点指向反转后的第一个节点
        beforeStart.next = pre;
        // 反转之前的第一个节点指向afterEnd，这个时候cur=afterEnd
        firstToReverse.next = cur;
        // 返回反转后的最后一个节点，也就是下一组需要反转的节点的前驱节点
        return firstToReverse;
    }
}
