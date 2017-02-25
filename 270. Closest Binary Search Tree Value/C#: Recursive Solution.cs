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
    public int ClosestValue(TreeNode root, double target) 
    {
        TreeNode kid = root.val > target ? root.left : root.right;
        if(kid == null)
            return root.val;
        int kidValue = ClosestValue(kid, target);
        return Math.Abs(target - root.val) < Math.Abs(target - kidValue) ? root.val : kidValue;
    }
}
