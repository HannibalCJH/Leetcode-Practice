/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(max(m,n))，空间复杂度O(m+n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        // 遍历两个链表存下每个节点的值
        while(l1 != null || l2 != null)
        {
            if(l1 != null)
            {
                list1.add(l1.val);
                l1 = l1.next;
            }
            if(l2 != null)
            {
                list2.add(l2.val);
                l2 = l2.next;
            }
        }
        
        ListNode pre = null;
        int idx1 = list1.size() - 1, idx2 = list2.size() - 1;
        int carry = 0;
        // 倒序遍历节点值
        while(idx1 >= 0 || idx2 >= 0 || carry > 0)
        {
            int num1 = idx1 >= 0 ? list1.get(idx1--) : 0;
            int num2 = idx2 >= 0 ? list2.get(idx2--) : 0;
            int sum = num1 + num2 + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
