/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        if(head == null)
            return null;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        // 复制头节点
        map.put(node, new RandomListNode(node.label));
        while(node != null)
        {
            // 复制下一个节点
            map.get(node).next = copyNode(node.next, map);
            // 复制随机节点
            map.get(node).random = copyNode(node.random, map);
            node = node.next;
        }
        return map.get(head);
    }
    
    private RandomListNode copyNode(RandomListNode node, HashMap<RandomListNode, RandomListNode> map)
    {
        if(node == null)
            return null;
        
        if(!map.containsKey(node))
        {
            map.put(node, new RandomListNode(node.label));
        }
        return map.get(node);
    }
}
