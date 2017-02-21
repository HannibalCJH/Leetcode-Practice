/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 递归法
    // 时间复杂度O(n)，空间复杂度O(n)
    public void connect(TreeLinkNode root) 
    {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            // 这一层是叶子节点
            if(queue.peek().left == null)
                break;
            // 每层开始初始化前一个兄弟节点为空
            TreeLinkNode pre = null;
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeLinkNode cur = queue.poll();
                // 前一个兄弟节点的右节点指向当前节点的左节点
                if(pre != null)
                    pre.right.next = cur.left;
                // 左节点的右指针指向右节点
                cur.left.next = cur.right;
                pre = cur;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
    }
}
