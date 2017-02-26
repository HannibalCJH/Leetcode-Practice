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
    // 时间复杂度O(n)，空间复杂度O(h)，树的高度
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        if(root == null)
            return false;
        return dfs(root, sum, 0);
    }
    
    private boolean dfs(TreeNode node, int sum, int cur)
    {
        cur += node.val;
        // 搜索到一个叶节点进行判断
        if(node.left == null && node.right == null)
        {
            return cur == sum ? true : false;
        }
        
        boolean left = false, right = false;
        if(node.left != null)
            left = dfs(node.left, sum, cur);
        if(node.right != null)
            right = dfs(node.right, sum, cur);
        return left || right;
    }
}
