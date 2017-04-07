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
    public TreeNode UpsideDownBinaryTree(TreeNode root) 
    {
        if(root == null || root.left == null)
            return root;
        
        TreeNode left = root.left, right = root.right;
        // 新根，即原来整棵树的最左边的叶节点
        TreeNode newRoot = UpsideDownBinaryTree(left);
        // 顺时针翻转
        left.left = right;
        left.right = root;
        // 重置原来根节点的左右子树
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
