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
    // 时间复杂度O(h)，空间复杂度O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        // 发现目标节点则通过返回值标记该子树发现了某个目标结点
        if(root == null || root == p || root == q)
            return root;
        // 查看左子树中是否有目标结点，没有为null
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        // 查看右子树是否有目标节点，没有为null
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        // 都不为空，说明左右子树都有目标结点，则公共祖先就是本身
        if(leftTree != null && rightTree != null)
            return root;
        // 如果发现了目标节点，则继续向上标记为该目标节点
        if(leftTree != null)
            return leftTree;
        if(rightTree != null)
            return rightTree;
            
        return null;
    }
}
