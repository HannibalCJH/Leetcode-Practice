/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     public int val;
 *     public TreeLinkNode left, right, next;
 *     public TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度(h)，h为树的高度
    TreeLinkNode pre;  // 同一层的前一个节点，如果是一层的开始则lastNode为null
    Queue<TreeLinkNode> queue = new Queue<TreeLinkNode>();
    
    public void Connect(TreeLinkNode root) 
    {
        if(root == null)
            return;
            
        queue.Enqueue(root);
        while(queue.Count > 0)
        {
            int size = queue.Count;
            pre = null;
            for(int i = 0; i < size; i++)
            {
                TreeLinkNode cur = queue.Dequeue();
                CheckChild(cur.left);
                CheckChild(cur.right);
            }
        }
    }
    
    private void CheckChild(TreeLinkNode node)
    {
        if(node != null)
        {
            if(pre != null)
                pre.next = node;
            pre = node;
            queue.Enqueue(node);
        }
    }
}
