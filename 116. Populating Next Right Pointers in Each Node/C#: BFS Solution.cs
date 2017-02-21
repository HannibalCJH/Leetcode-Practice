/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     public int val;
 *     public TreeLinkNode left, right, next;
 *     public TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 递归法
    // 时间复杂度O(n)，空间复杂度O(n)
    public void Connect(TreeLinkNode root) 
    {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new Queue<TreeLinkNode>();
        queue.Enqueue(root);
        while(queue.Count > 0)
        {
            // 这一层是叶子节点
            if(queue.Peek().left == null)
                break;
            // 每层开始初始化前一个兄弟节点为空
            TreeLinkNode pre = null;
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                TreeLinkNode cur = queue.Dequeue();
                // 前一个兄弟节点的右节点next指针指向当前节点的左节点
                if(pre != null)
                    pre.right.next = cur.left;
                // 左节点的next指针指向右节点
                cur.left.next = cur.right;
                pre = cur;
                queue.Enqueue(cur.left);
                queue.Enqueue(cur.right);
            }
        }
    }
}
