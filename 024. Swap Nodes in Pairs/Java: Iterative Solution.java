/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        // 伪表头
        ListNode dummy = new ListNode(-1);
        // 伪表头的下一个节点初始化为头节点，这样如果只有一个节点，我们返回dummy.next就是这个头节点
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        // 要交换的是cur和cur.next，这两个节点不能为空
        while(cur != null && cur.next != null)
        {
            // 下一个节点B
            ListNode next = cur.next;
            // 当前节点A的next指向下下个节点C
            cur.next = next.next;
            // 前驱节点指向B
            pre.next = next;
            // B节点往回指向A
            next.next = cur;
            // 移动到下一组
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
