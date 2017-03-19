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
        List<int> list1 = new List<int>();
        List<int> list2 = new List<int>();
        
        while(l1 != null || l2 != null)
        {
            if(l1 != null)
            {
                list1.Add(l1.val);
                l1 = l1.next;
            }
            if(l2 != null)
            {
                list2.Add(l2.val);
                l2 = l2.next;
            }
        }
        
        ListNode pre = null;
        int idx1 = list1.Count - 1, idx2 = list2.Count - 1;
        int carry = 0;
        while(idx1 >= 0 || idx2 >= 0 || carry > 0)
        {
            int num1 = idx1 >= 0 ? list1[idx1--] : 0;
            int num2 = idx2 >= 0 ? list2[idx2--] : 0;
            int sum = num1 + num2 + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
