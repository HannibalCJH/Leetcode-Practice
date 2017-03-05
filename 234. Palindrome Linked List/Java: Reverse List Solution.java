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
	public boolean isPalindrome(ListNode head) 
	{
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 奇数个节点，跳过中间节点
        if(fast != null)
            slow = slow.next;
        // 反正链表的后半截
        fast = reverse(slow);
        slow = head;
        // 分别从两端往中间走，比较两端的节点值
        while(fast != null)
        {
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    // 反转链表
    private ListNode reverse(ListNode node)
    {
        if(node == null)
            return null;
        ListNode pre = node, cur = node.next;
        pre.next = null;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
