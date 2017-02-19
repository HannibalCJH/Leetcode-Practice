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
        TreeNode node = root;
        while(true)
        {
            if(node.val > p.val && node.val > q.val)
                node = node.left;
            else if(node.val < p.val && node.val < q.val)
                node = node.right;
            else
                break;
        }
        return node;
    }
}
