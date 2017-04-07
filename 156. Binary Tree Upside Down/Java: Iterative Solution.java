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
        // pre指向cur的父节点，next指向cur的左节点
        TreeNode pre = null, cur = root, next = null;
        // cur父节点原来的右节点即兄弟右节点
        TreeNode preRight = null;
        while(cur != null)
        {
            // next设为左节点
            next = cur.left;
            // 顺时针翻转
            // 左节点设为兄弟右节点
            cur.left = preRight;
            // 把preRight设为当前父节点的右节点，作为下一层的兄弟右节点
            preRight = cur.right;
            // 右节点设为父节点
            cur.right = pre;
            // 下一层
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
