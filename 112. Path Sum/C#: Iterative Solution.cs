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
    public bool HasPathSum(TreeNode root, int sum) 
    {
        if(root == null)
            return false;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.Push(root);
        while(stack.Count > 0)
        {
            root = stack.Pop();
            if(root.left == null && root.right == null && root.val == sum)
                return true;
                
            if(root.left != null)
            {
                root.left.val += root.val;
                stack.Push(root.left);
            }
            
            if(root.right != null)
            {
                root.right.val += root.val;
                stack.Push(root.right);
            }
        }
        return false;
    }
}
