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
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    public int sumOfLeftLeaves(TreeNode root) 
    {  
        return dfs(root, false);
    }
    
    private int dfs(TreeNode node, boolean leftChild)
    {
        if(node == null)
            return 0;
        // 是左节点且是叶子节点
        if(leftChild && node.left == null && node.right == null)
            return node.val;
        return dfs(node.left, true) + dfs(node.right, false);
    }
}
