/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // 把复制的节点插入到原来的链表
    // 时间复杂度O(n)，空间复杂度O(1)
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        if(head == null)
            return null;
        
        RandomListNode node = head;
        // 第一遍，复制原来节点形成克隆节点并插入原来的链表
        while(node != null)
        {
            // 复制节点
            RandomListNode cloneNode = new RandomListNode(node.label);
            // 把克隆节点插入原来节点和下一个节点之间
            cloneNode.next = node.next;
            node.next = cloneNode;
            // 指针跳过两个节点，指向原来的下一个节点
            node = cloneNode.next;
        }
        
        // 第二遍，复制随机节点
        node = head;
        while(node != null)
        {
            RandomListNode cloneNode = node.next;
            // 克隆节点的随机节点即原来节点的随机节点的下一个节点
            if(node.random != null)
                cloneNode.random = node.random.next;
            // 指针跳过两个节点，指向原来的下一个节点
            node = cloneNode.next;
        }
        
        // 第三遍，拆分链表
        node = head;
        RandomListNode cloneHead = node.next;
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
