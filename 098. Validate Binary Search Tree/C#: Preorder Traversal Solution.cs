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
    TreeNode pre;
    
    public bool IsValidBST(TreeNode root) 
    {
        if(root == null)
            return true;
        
        if(!IsValidBST(root.left))
            return false;
            
        if(pre != null && pre.val >= root.val)
            return false;
        pre = root;
        
        return IsValidBST(root.right);
    }
}
