/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 反转链表法
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        // 反转两个链表
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode head = addListNumbers(l1, l2);
        return reverseList(head);
    }
    
    private ListNode addListNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int carry = 0, sum = 0;
        while(l1 != null || l2 != null)
        {
            if(l1 == null)
                l1 = new ListNode(0);
            if(l2 == null)
                l2 = new ListNode(0);
            sum = l1.val + l2.val + carry;
            ListNode cur = new ListNode(sum % 10);
            pre.next = cur;
            pre = cur;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
        }
        
        if(carry == 1)
            pre.next = new ListNode(1);
        return head.next;
    }
    
    private ListNode reverseList(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
            
        ListNode pre = head, cur = head.next;
        ListNode next;
        pre.next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
