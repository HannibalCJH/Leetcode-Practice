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
    // 时间复杂度O(h)，空间复杂度O(h)，h为树的高度
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
	// 对于二叉搜索树，公共祖先的值一定大于等于较小的节点，小于等于较大的节点
	// 换言之，在遍历树的时候，如果当前结点大于两个节点，则结果在当前结点的左子树里，
	// 如果当前结点小于两个节点，则结果在当前节点的右子树
        if(root.val > p.val && root.val > q.val) 
            return lowestCommonAncestor(root.left, p, q);
        if(root.val < p.val && root.val < q.val) 
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
