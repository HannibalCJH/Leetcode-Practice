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
    int maxLevel = 1;
    int result;
    
    public int findBottomLeftValue(TreeNode root) 
    {
        result = root.val;
        findTreeNode(root, 1);
        return result;
    }
    
    private void findTreeNode(TreeNode node, int level)
    {
        if(node == null)
            return;
        // 只有第一次到达深度比maxLevel大的时候更新
        if(level > maxLevel)
        {
            result = node.val;
            maxLevel = level;
        }
        
        findTreeNode(node.left, level + 1);
        findTreeNode(node.right, level + 1);
    }
}
