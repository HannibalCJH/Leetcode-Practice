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
    // 时间复杂度O(n)，空间复杂度O(h)其中h为树的高度
    public boolean isValidBST(TreeNode root) 
    {
        return dfs(root, null, null);
    }
    // 这里上限和下限要用Integer，如果用int的话翻一个根节点为2^31-1时会返回true
    private boolean dfs(TreeNode node, Integer max, Integer min)
    {
        if(node == null)
            return true;
        if((max != null && node.val >= max) || (min != null && node.val <= min))
            return false;
        boolean left = dfs(node.left, node.val, min);
        boolean right = dfs(node.right, max, node.val);
        return left && right;
    }
}
