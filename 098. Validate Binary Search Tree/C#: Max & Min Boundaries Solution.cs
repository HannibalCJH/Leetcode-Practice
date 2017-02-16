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
    public bool IsValidBST(TreeNode root) 
    {
        return DFS(root, long.MaxValue, long.MinValue);       
    }
    
    private bool DFS(TreeNode node, long maxValue, long minValue)
    {
        if(node == null)
            return true;
        
        if(node.val >= maxValue)
            return false;
        if(node.val <= minValue)
            return false;
        bool left = DFS(node.left, node.val, minValue);
        bool right = DFS(node.right, maxValue, node.val);
        return left && right;
    }
}
