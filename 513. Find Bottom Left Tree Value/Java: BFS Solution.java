/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int findBottomLeftValue(TreeNode root) 
    {
        TreeNode leftMost = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // BFS
        while(!queue.isEmpty())
        {
            int size = queue.size();
            // 更新leftMost为下一层的第一个节点
            leftMost = queue.peek();
            for(int i = 0; i < size; i++)
            {
                TreeNode cur = queue.poll();
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return leftMost.val;
    }
}
