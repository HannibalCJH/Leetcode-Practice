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
    // 时间复杂度O(m+n)，空间复杂度O(max(m,n))，递归栈空间
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
        return helper(l1, l2, 0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry)
    {
    	// 如果最后还有进位，则最后加上一个节点
        if(l1 == null && l2 == null)
            return carry == 0 ? null : new ListNode(carry);
        
        // 当有一个链表已经遍历完成，设置该链表为0节点然后继续往下层遍历
        // 这样当在计算sum的时候能够把已经遍历完的链表值变成0
        // l1链表已经遍历完，l2还有剩余节点
        // sum = 0 + l2.val + carry
        if(l1 == null && l2 != null)
            l1 = new ListNode(0);
        // l2链表已经遍历完，l1还有剩余节点
        // sum = l1.val + 0 + carry
        if(l2 == null && l1 != null)
            l2 = new ListNode(0);
        
        int sum = l1.val + l2.val + carry;
        ListNode curr = new ListNode(sum % 10);  // 生成当前位置的节点
        curr.next = helper(l1.next, l2.next, sum / 10);  // 往下一层，传入进位数
        return curr;
    }
}
