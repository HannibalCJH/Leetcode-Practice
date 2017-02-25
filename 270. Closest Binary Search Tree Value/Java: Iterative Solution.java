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
    // 迭代法
    // 时间复杂度O(logn)，空间复杂度O(1)
    public int closestValue(TreeNode root, double target) 
    {  
        int closest = root.val;
        while(root != null)
        {
            closest = Math.abs(target - root.val) < Math.abs(closest - target) ? root.val : closest;
            root = root.val < target ? root.right : root.left;
        }
        return closest;
    }
}
