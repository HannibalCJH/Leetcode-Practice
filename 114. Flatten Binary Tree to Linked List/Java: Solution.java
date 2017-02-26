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
    // 先序遍历
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    TreeNode preNode;
    
    public void flatten(TreeNode root) 
    {
        if(root == null)
            return;
        // 设置先序遍历的前一个节点的左子树为空，右子树为当前节点
        if(preNode != null)
        {
            preNode.left = null;
            preNode.right = root;
        }
        
        preNode = root;
        // 当前节点的右子树在递归左子树时会被修改，所以需要保存
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
