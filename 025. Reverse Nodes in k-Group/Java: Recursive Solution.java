/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 递归思路类似Swap Nodes in Pairs，都是把下一组开头的节点传入递归函数
    // 时间复杂度O(n)，空间复杂度O(n)
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        int count = 0;
        // 往前走k个节点，到第k+1个节点
        while(cur != null && count < k)
        {
            cur = cur.next;
            count++;
        }
        
        // 找到第k+1个节点，还没到链表末尾
        if(count == k)
        {
            // 递归，反转下一组k个节点
            cur = reverseKGroup(cur, k);
            // 反转当前的k个节点
            while(count-- > 0)
            {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            // 把head指向cur，因为当没有找到第k+1个节点即余下的节点不到k个时我们直接就返回head
            head = cur;
        }
        return head;
    }
}
