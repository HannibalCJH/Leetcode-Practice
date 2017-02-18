/**
 * Definition for singly-linked list with a random pointer.
 * public class RandomListNode {
 *     public int label;
 *     public RandomListNode next, random;
 *     public RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode CopyRandomList(RandomListNode head) 
    {
        if(head == null)
            return null;
        
        Dictionary<RandomListNode, RandomListNode> map = new Dictionary<RandomListNode, RandomListNode>();
        RandomListNode node = head;
        // 复制头节点
        map.Add(node, new RandomListNode(node.label));
        while(node != null)
        {
            // 复制下一个节点
            map[node].next = CopyNode(node.next, map);
            // 复制随机节点
            map[node].random = CopyNode(node.random, map);
            node = node.next;
        }
        return map[head];
    }
    
    private RandomListNode CopyNode(RandomListNode node, Dictionary<RandomListNode, RandomListNode> map)
    {
        if(node == null)
        {
            return null;
        }
        else if(!map.ContainsKey(node))
        {
            map.Add(node, new RandomListNode(node.label));
        }
        return map[node];
    }
}
