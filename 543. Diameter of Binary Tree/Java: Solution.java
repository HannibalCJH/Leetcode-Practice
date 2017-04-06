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
    // 思路和Binary Tree Maximum Path Sum一模一样，只是每次加的不是节点值而是
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    int max = 1;
    
    public int diameterOfBinaryTree(TreeNode root) 
    {
        searchDiameter(root);
        // 我们计算的是路径上的节点数，而返回值要求是边数，那只要减1就行
        return max - 1;
    }
    
    private int searchDiameter(TreeNode node)
    {
        if(node == null)
            return 0;
        
        int left = searchDiameter(node.left);
        int right = searchDiameter(node.right);
        int sum = 1;
        if(left > 0)
            sum += left;
        if(right > 0)
            sum += right;
        max = Math.max(sum, max);
        return Math.max(left + 1, right + 1);
    }
}
