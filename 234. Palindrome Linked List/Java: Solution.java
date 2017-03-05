/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public boolean isPalindrome(ListNode head) 
    {
        int count = 0;
        ListNode node = head;
        // 遍历一遍得到节点总数
        while(node != null)
        {
            node = node.next;
            count++;
        }
        node = head;
        int mid = count / 2;
        // 存储前一半节点值，奇数个情况下不包括中间点
        int[] half = new int[mid];  
        // 以下两个for循环都为遍历第二遍，分别是前半部分和后半部分
        // 第二遍遍历前半部分，存储前一半的值
        for(int i = 0; i < mid; i++)
        {
            half[i] = node.val;
            node = node.next;
        }
        // 奇数个情况下跳过中间节点
        if(count % 2 > 0)
            node = node.next;
        // 第二遍遍历后半部分，逐一比较
        for(int i = mid - 1; i >= 0; i--)
        {
            if(node.val != half[i])
        	return false;
            node = node.next;
        }
        return true;
    }
}
