/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int FindBottomLeftValue(TreeNode root) 
    {
        TreeNode leftMost = root;
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        while(queue.Count > 0)
        {
            int size = queue.Count;
            // 更新leftMost为下一层的第一个节点
            leftMost = queue.Peek();
            for(int i = 0; i < size; i++)
            {
                TreeNode cur = queue.Dequeue();
                if(cur.left != null)
                    queue.Enqueue(cur.left);
                if(cur.right != null)
                    queue.Enqueue(cur.right);
            }
        }
        return leftMost.val;
    }
}
