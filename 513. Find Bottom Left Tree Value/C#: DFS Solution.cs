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
    int maxLevel = 1;
    int result;
    
    public int FindBottomLeftValue(TreeNode root) 
    {
        result = root.val;
        FindTreeNode(root, 1);
        return result;
    }
    
    private void FindTreeNode(TreeNode node, int level)
    {
        if(node == null)
            return;
        
        if(level > maxLevel)
        {
            result = node.val;
            maxLevel = level;
        }
        
        FindTreeNode(node.left, level + 1);
        FindTreeNode(node.right, level + 1);
    }
}
