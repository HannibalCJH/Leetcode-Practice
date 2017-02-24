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
    // 时间复杂度O(h)，空间复杂度O(h)，h为树的高度
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) 
    {
        // 当p节点的右子树中搜索到了最左边的叶节点或是右子树为空
        if(root == null)
            return null;
        // 这里有两种情况
        // 1. 一开始找p节点的时候路径上的节点大于p节点我们找其左子树
        // 2. 已经找到p节点的情况下会先进入右子树，而右子树中的节点都是大于p节点的所以会一直向右子树的最左边找
        if(p.val < root.val)
        {
            TreeNode leftResult = inorderSuccessor(root.left, p);
            return leftResult == null ? root : leftResult;
        }
        // 当找到了p节点也还是继续搜索右子树，因为它的后继节点中右子树中
        return inorderSuccessor(root.right, p);
    }
}
