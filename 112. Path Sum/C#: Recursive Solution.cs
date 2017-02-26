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
    public bool HasPathSum(TreeNode root, int sum) 
    {
        if(root == null)
            return false;
        return DFS(root, sum, 0);
    }
    
    private bool DFS(TreeNode node, int sum, int cur)
    {
        cur += node.val;
        if(node.left == null && node.right == null)
        {
            return cur == sum ? true : false;
        }
        
        bool left = false, right = false;
        if(node.left != null)
            left = DFS(node.left, sum, cur);
        if(node.right != null)
            right = DFS(node.right, sum, cur);
        return left || right;
    }
}
