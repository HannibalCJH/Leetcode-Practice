/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(m+n)，空间复杂度O(m+n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        // 哈希表存index和值
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        // 遍历两个链表把index和对应的值存入哈希表 
        int i = 0, j = 0;
        ListNode pt1 = l1, pt2 = l2;
        while(pt1 != null)
        {
            map1.put(++i, pt1.val);
            pt1 = pt1.next;
        }
        while(pt2 != null)
        {
            map2.put(++j, pt2.val);
            pt2 = pt2.next;
        }
        
        ListNode pre = null;
        int carry = 0, sum = 0;
        while(i > 0 || j > 0 || carry > 0)
        {
            int val1 = i > 0 ? map1.get(i--) : 0;
            int val2 = j > 0 ? map2.get(j--) : 0;
            
            sum = val1 + val2 + carry;
            ListNode cur = new ListNode(sum % 10);
            cur.next = pre;
            pre = cur;
            carry = sum / 10;
        }
        return pre;   
    }
}
