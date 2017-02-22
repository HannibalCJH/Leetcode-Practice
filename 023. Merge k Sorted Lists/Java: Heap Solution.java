/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(nlogk)，n为所有节点的总数，k为总共有几个链表
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.length == 0)
            return null;
        
        // 把所有链表的头加入堆，按照值从小到大排列，堆大小可以直接设置成链表的总数
        PriorityQueue<ListNode> heads = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2)
            {
                return node1.val - node2.val;
            }
        });
        
        for(ListNode head : lists)
        {
            if(head != null)
                heads.offer(head);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(!heads.isEmpty())
        {
            // 取出最小的链表的头节点
            ListNode cur = heads.poll();
            pre.next = cur;
            // 如果这个链表后面还有节点就顶上
            if(cur.next != null)
                heads.offer(cur.next);
            pre = pre.next;
        }
        return dummy.next;
    }
}
