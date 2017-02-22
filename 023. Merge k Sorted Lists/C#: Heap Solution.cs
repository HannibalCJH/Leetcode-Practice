/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //时间复杂度O(nlogk)，空间复杂度O(k)
    public ListNode MergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.Length == 0)
            return null;
        // 用SortedDictionary模拟堆，键值对[ListNode.val, List<ListNode>]
        SortedDictionary<int, List<ListNode>> heap = new SortedDictionary<int, List<ListNode>>();
        foreach(ListNode head in lists)
        {
            if(head != null)
            {
                // 如果heap中已经有这个值，把该节点挂到这个值对应的列表中
                if(heap.ContainsKey(head.val))
                    heap[head.val].Add(head);
                else
                    // 不存在，则直接在heap加入这个键并开辟一个新的列表
                    heap.Add(head.val, new List<ListNode>(){head});
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(heap.Any())
        {
            // 获取值最小的节点列表，可能有多个节点
            List<ListNode> minList = heap.First().Value;
            // 获取这个列表中的第一个节点，加到结果链表的后面
            ListNode cur = minList[0];
            pre.next = cur;
            // 如果这个节点是minList列表中最后一个节点，把这个最小值的键从heap中删除
            if(minList.Count == 1)
            {
                heap.Remove(cur.val);
            }
            else
            {
                // 如果minList列表中还有其他等值的节点，则只删除minList列表中的第一个节点，后面的节点顶上
                minList.RemoveAt(0);
            }
            
            if(cur.next != null)
            {
                if(heap.ContainsKey(cur.next.val))
                {
                    heap[cur.next.val].Add(cur.next);
                }
                else
                {
                    heap.Add(cur.next.val, new List<ListNode>(){cur.next});
                }
            }
            
            pre = pre.next;
        }
        return dummy.next;
    }
}
