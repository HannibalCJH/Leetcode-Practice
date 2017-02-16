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
    // 自底向上，根据先序遍历的顺序进行比较
    // 时间复杂度O(n)，空间复杂度O(h)
    TreeNode pre;
    
    public boolean isValidBST(TreeNode root) 
    {
        if(root == null)
            return true;
            
        if(!isValidBST(root.left))
            return false;
        
        if(pre != null && root.val <= pre.val)
            return false;
        
        pre = root;
        return isValidBST(root.right);
    }
}
