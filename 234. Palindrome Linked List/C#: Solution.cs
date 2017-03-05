/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public bool IsPalindrome(ListNode head) 
    {
        int count = 0;
        ListNode node = head;
        while(node != null)
        {
            node = node.next;
            count++;
        }
        
        node = head;
        int mid = count / 2;
        int[] half = new int[mid];
        for(int i = 0; i < mid; i++)
        {
            half[i] = node.val;
            node = node.next;
        }
        
        if(count % 2 > 0)
            node = node.next;
        
        for(int i = mid - 1; i >= 0; i--)
        {
            if(node.val != half[i])
                return false;
            node = node.next;
        }
        return true;
    }
}
