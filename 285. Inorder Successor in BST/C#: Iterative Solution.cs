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
    public TreeNode InorderSuccessor(TreeNode root, TreeNode p) 
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != p)
        {
            stack.Push(root);
            if(root.val > p.val)
                root = root.left;
            else
                root = root.right;
        }
        
        if(root.right != null)
        {
            root = root.right;
            while(root.left != null)
                root = root.left;
            return root;
        }
        else
        {
            while(stack.Count > 0 && stack.Peek().val < p.val)
                stack.Pop();
            return stack.Count == 0 ? null : stack.Pop();
        }
    }
}
