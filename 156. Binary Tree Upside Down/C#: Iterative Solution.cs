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
        TreeNode pre = null, cur = root, next = null;
        TreeNode preRight = null;
        
        while(cur != null)
        {
            next = cur.left;
            cur.left = preRight;
            preRight = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
