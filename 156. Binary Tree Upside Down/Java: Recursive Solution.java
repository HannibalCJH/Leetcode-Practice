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
    // 时间复杂度O(n)，n为左节点的个数
    // 空间复杂度O(h)，h为递归左子树的最大深度
    public TreeNode upsideDownBinaryTree(TreeNode root) 
	{
	    // 根为空或者左节点为空就返回
		if(root == null || root.left == null)
            return root;
        // 记录当前节点的左右节点
        TreeNode left = root.left, right = root.right;
        // 递归左节点，返回的新的根就是整棵树最左边的叶节点
        TreeNode newRoot = upsideDownBinaryTree(left);
        // 进行顺时针翻转，原来的左节点作为根节点
        // 新左节点设为原来的右节点
        left.left = right;
        // 新右节点设为原来的根节点
        left.right = root;
        // 把原来根节点的左右子树设为空，防止陷入循环，其左右节点会在上一层被重新定义
        root.left = null;
        root.right = null;
        // 返回的节点都是新的根，从最底层往上返回时不会改变
        return newRoot;
	}
}
