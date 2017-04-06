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
    int max = 1;
    
    public int DiameterOfBinaryTree(TreeNode root) 
    {
        SearchDiameter(root);
        return max - 1;
    }
    
    private int SearchDiameter(TreeNode node)
    {
        if(node == null)
            return 0;
            
        int left = SearchDiameter(node.left);
        int right = SearchDiameter(node.right);
        int sum = 1;
        if(left > 0)
            sum += left;
        if(right > 0)
            sum += right;
            
        max = Math.Max(sum, max);
        return Math.Max(left + 1, right + 1);
    }
}
