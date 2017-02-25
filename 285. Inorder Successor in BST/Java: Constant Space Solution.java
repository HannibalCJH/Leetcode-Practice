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
    // 与递归法的思想一致
    // 时间复杂度O(h)，h为树的高度
    // 空间复杂度O(1)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) 
    {
        TreeNode succ = null;
        while(root != null)
        {
            // 往左子树找时更新succ
            if(root.val > p.val)
            {
                succ = root;
                root = root.left;
            }
            else
                // 当找到p节点继续往它的右子树搜索
                root = root.right;
        }
        return succ;
    }
}
