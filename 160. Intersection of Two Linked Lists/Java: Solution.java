/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode pt1 = headA, pt2 = headB;
        int m = 0, n = 0;
        // 计算两个链表的长度
        while(pt1 != null || pt2 != null)
        {
            if(pt1 != null)
            {
                pt1 = pt1.next;
                m++;
            }
            if(pt2 != null)
            {
                pt2 = pt2.next;
                n++;
            }
        }
        // 把长的链表往前推进到和短链表一样长的位置
        int step = Math.abs(m - n);
        if(m > n)
        {
            for(int i = 0; i < step; i++)
                headA = headA.next;
        }
        else
        {
            for(int i = 0; i < step; i++)
                headB = headB.next;
        }
        // 两个链表一起往前走，当找到相同节点就是相遇的节点
        while(headA != null)
        {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
