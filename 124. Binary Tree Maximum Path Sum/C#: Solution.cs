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
    int max = Int32.MinValue;
    
    public int MaxPathSum(TreeNode root) 
    {
        MaxSum(root);
        return max;
    }
    
    private int MaxSum(TreeNode node)
    {
        if(node == null)
            return 0;
            
        int left = MaxSum(node.left);
        int right = MaxSum(node.right);
        
        int cur = node.val;
        if(left > 0)
            cur += left;
        if(right > 0)
            cur += right;
        if(cur > max)
            max = cur;
            
        return Math.Max(node.val, Math.Max(node.val + left, node.val + right));
    }
}
