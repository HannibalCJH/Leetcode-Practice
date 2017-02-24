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
    public TreeNode InorderSuccessor(TreeNode root, TreeNode p) 
    {
        if(root == null)
            return null;
            
        if(root.val > p.val)
        {
            TreeNode leftResult = InorderSuccessor(root.left, p);
            return leftResult == null ? root : leftResult;
        }
        return InorderSuccessor(root.right, p);
    }
}
