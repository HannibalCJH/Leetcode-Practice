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
    TreeNode preNode;
    
    public void Flatten(TreeNode root) 
    {
        if(root == null)
            return;
        
        if(preNode != null)
        {
            preNode.left = null;
            preNode.right = root;
        }
        
        preNode = root;
        TreeNode right = root.right;
        Flatten(root.left);
        Flatten(right);
    }
}
