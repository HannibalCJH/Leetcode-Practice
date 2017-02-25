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
        int closest = root.val;
        while(root != null)
        {
            closest = Math.Abs(target - root.val) < Math.Abs(target - closest) ? root.val : closest;
            root = root.val < target ? root.right : root.left;
        }
        return closest;
    }
}
