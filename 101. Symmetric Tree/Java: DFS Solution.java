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
    // 递归法
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    public boolean isSymmetric(TreeNode root) 
    {
        if(root == null)
            return true;
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode lNode, TreeNode rNode)
    {
        if(lNode == null && rNode == null)
            return true;
        if(lNode == null || rNode == null || lNode.val != rNode.val)
            return false;
        // lNode的左子树和rNode的右子树比较
        boolean flag1 = dfs(lNode.left, rNode.right);
        // lNode的右子树和rNode的左子树比较
        boolean flag2 = dfs(lNode.right, rNode.left);
        return flag1 && flag2;
    }
}
