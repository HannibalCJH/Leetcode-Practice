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
    
    public IList<int> PreorderTraversal(TreeNode root) 
    {
        if(root != null)
        {
            result.Add(root.val);
            PreorderTraversal(root.left);
            PreorderTraversal(root.right);
        }
        return result;
    }
}
