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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
            
        boolean firstOfLevel;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            firstOfLevel = true;
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                // 当前节点为这一层的最右边的节点
                if(firstOfLevel)
                {
                    result.add(node.val);
                    firstOfLevel = false;
                }
                // 先右子树后左子树
                if(node.right != null)
                    queue.offer(node.right);
                if(node.left != null)
                    queue.offer(node.left);
            }
        }
        return result;
    }
}
