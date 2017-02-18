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
            
        RandomListNode node = head;
        // 第一遍，复制节点
        while(node != null)
        {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
        
        node = head;
        // 第二遍，复制随机节点
        while(node != null)
        {
            RandomListNode cloneNode = node.next;
            if(node.random != null)
                cloneNode.random = node.random.next;
            node = cloneNode.next;
        }
        
        node = head;
        RandomListNode cloneHead = node.next;
        // 第三遍，拆分链表
        while(node != null)
        {
            RandomListNode cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
            if(cloneNode.next != null)
                cloneNode.next = node.next;
        }
        return cloneHead;
    }
}
