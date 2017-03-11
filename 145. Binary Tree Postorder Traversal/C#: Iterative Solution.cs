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
    public IList<int> PostorderTraversal(TreeNode root) 
    {
        if(root == null)
            return new List<int>();
        
        IList<int> result = new List<int>();
        Stack<int> reverse = new Stack<int>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || stack.Count > 0)
        {
            if(root != null)
            {
                reverse.Push(root.val);
                stack.Push(root);
                root = root.right;
            }
            else
            {
                root = stack.Pop();
                root = root.left;
            }
        }
        
        while(reverse.Count > 0)
        {
            result.Add(reverse.Pop());
        }
        
        return result;
    }
}
