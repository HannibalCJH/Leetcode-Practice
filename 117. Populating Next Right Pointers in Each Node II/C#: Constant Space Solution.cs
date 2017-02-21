/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     public int val;
 *     public TreeLinkNode left, right, next;
 *     public TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    // 下一层的第一个节点
    TreeLinkNode head = null;
    // 下一层的前一个节点
    TreeLinkNode prev = null;
    
    public void Connect(TreeLinkNode root) 
    {
        // 当前层的节点
        TreeLinkNode cur = root;
        while(cur != null) 
        {
            // 遍历当前层
            while(cur != null) 
            {
                // 左子树
                CheckChild(cur.left);
                // 右子树
                CheckChild(cur.right);
                // 移动到当前层的下一个节点
                cur = cur.next;
            }
            
            // 移动到下一层的第一个节点，当下一层的第一个节点为空的时候跳出循环
            cur = head;
            head = null;
            prev = null;
        }
    }
    
    private void CheckChild(TreeLinkNode node)
    {
        // 左子树
        if(node != null) 
        {
            if(prev != null)
                prev.next = node;
            else
                // 如果下一层的上一个节点是空则当前节点是下一层的第一个节点
                head = node;
            prev = node;
        }
    }
}
