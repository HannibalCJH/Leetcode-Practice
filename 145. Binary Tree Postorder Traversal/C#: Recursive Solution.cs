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
    IList<int> result = new List<int>();
    
    public IList<int> PostorderTraversal(TreeNode root) 
    {
        if(root != null)
        {
            PostorderTraversal(root.left);
            PostorderTraversal(root.right);
            result.Add(root.val);
        }
        return result;
    }
}
