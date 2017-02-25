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
    public bool IsSymmetric(TreeNode root) 
    {
        if(root == null)    
            return true;
        return DFS(root.left, root.right);
    }
    
    private bool DFS(TreeNode lNode, TreeNode rNode)
    {
        if(lNode == null && rNode == null)
            return true;
            
        if(lNode == null || rNode == null || lNode.val != rNode.val)
            return false;
        
        bool flag1 = DFS(lNode.right, rNode.left);
        bool flag2 = DFS(lNode.left, rNode.right);
        return flag1 && flag2;
    }
}
