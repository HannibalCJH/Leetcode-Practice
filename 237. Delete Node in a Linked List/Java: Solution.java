/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(1)，空间复杂度O(1)
    public void deleteNode(ListNode node) 
    {
        // 把下一个节点复制给node然后让node指向下下个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
