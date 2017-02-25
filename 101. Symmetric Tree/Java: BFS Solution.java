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
    // 迭代法
    // 时间复杂度O(n)，空间复杂度O(n)
    public boolean isSymmetric(TreeNode root) 
    {
        if(root == null)
            return true;
        Queue<TreeNode> lTree = new LinkedList<TreeNode>();
        Queue<TreeNode> rTree = new LinkedList<TreeNode>();
        lTree.offer(root.left);
        rTree.offer(root.right);
        // BFS
        while(!lTree.isEmpty() && !rTree.isEmpty())
        {
            TreeNode lNode = lTree.poll(), rNode = rTree.poll();
            if(lNode == null && rNode == null)
                continue;
            if(lNode == null || rNode == null || lNode.val != rNode.val)
                return false;
            lTree.offer(lNode.left);
            lTree.offer(lNode.right);
            rTree.offer(rNode.right);
            rTree.offer(rNode.left);
        }
        return lTree.isEmpty() && rTree.isEmpty();
    }
}
