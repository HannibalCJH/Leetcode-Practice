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
    public IList<int> PreorderTraversal(TreeNode root) 
    {
        if(root == null)
            return new List<int>();
        
        IList<int> result = new List<int>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || stack.Count > 0)
        {
            if(root != null)
            {
                result.Add(root.val);
                stack.Push(root);
                root = root.left;
            }
            else
            {
                root = stack.Pop();
                root = root.right;
            }
        }
        return result;
    }
}
