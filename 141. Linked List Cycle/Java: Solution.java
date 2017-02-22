/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean hasCycle(ListNode head) 
    {
        if(head == null)
            return false;
        ListNode slow = head, fast = head.next;
        // 慢指针每次走一步，快指针每次走两步，最后如果相会则有环
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
