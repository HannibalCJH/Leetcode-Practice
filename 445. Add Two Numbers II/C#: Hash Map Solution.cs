/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) 
    {
        Dictionary<int, int> map1 = new Dictionary<int, int>();
        Dictionary<int, int> map2 = new Dictionary<int, int>();
        
        int i = 0, j = 0;
        ListNode pt1 = l1, pt2 = l2;
        while(pt1 != null)
        {
            map1.Add(++i, pt1.val);
            pt1 = pt1.next;
        }
        
        while(pt2 != null)
        {
            map2.Add(++j, pt2.val);
            pt2 = pt2.next;
        }
        
        ListNode head = null;
        int sum = 0, carry = 0;
        while(i > 0 || j > 0 || carry > 0)
        {
            int val1 = i > 0 ? map1[i--] : 0;
            int val2 = j > 0 ? map2[j--] : 0;
            
            sum = val1 + val2 + carry;
            ListNode cur = new ListNode(sum % 10);
            cur.next = head;
            head = cur;
            carry = sum / 10;
        }
        return head;
    }
}
