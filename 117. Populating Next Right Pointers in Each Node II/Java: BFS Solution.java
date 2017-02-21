/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度(h)，h为树的高度
    TreeLinkNode pre;  // 同一层的前一个节点，如果是一层的开始则lastNode为null
    Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    
    public void connect(TreeLinkNode root) 
    {
        if(root == null)
            return;
            
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            pre = null;
            for(int i = 0; i < size; i++)
            {
                TreeLinkNode cur = queue.poll();
                checkChild(cur.left);
                checkChild(cur.right);
            }
        }
    }
    
    private void checkChild(TreeLinkNode node)
    {
        if(node != null)
        {
            if(pre != null)
                pre.next = node;
            pre = node;
            queue.offer(node);
        }
    }
}
