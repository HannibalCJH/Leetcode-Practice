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
    // 时间复杂度O(n)，n为节点的数目
    // 空间复杂度O(n)
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            // 记录每层的节点
            List<Integer> curLevel = new ArrayList<Integer>();
            // 这一层的节点数
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(curLevel);
        }
        return result;
    }
}
