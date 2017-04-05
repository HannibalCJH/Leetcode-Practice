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
    public int SumOfLeftLeaves(TreeNode root) 
    {
        return DFS(root, false);    
    }
    
    private int DFS(TreeNode node, bool leftChild)
    {
        if(node == null)
            return 0;
        if(leftChild && node.left == null && node.right == null)
            return node.val;
        return DFS(node.left, true) + DFS(node.right, false);
    }
}
