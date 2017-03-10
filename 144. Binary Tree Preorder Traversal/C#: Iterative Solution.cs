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
        stack.Push(root);
        while(stack.Count > 0)
        {
            TreeNode node = stack.Pop();
            result.Add(node.val);
            if(node.right != null)
                stack.Push(node.right);
            if(node.left != null)
                stack.Push(node.left);
        }
        return result;
    }
}
