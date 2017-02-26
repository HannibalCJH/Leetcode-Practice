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
    public void Flatten(TreeNode root) 
    {
        if(root == null)
            return;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.Push(root);
        while(stack.Count > 0)
        {
            TreeNode cur = stack.Pop();
            if(cur.right != null)
                stack.Push(cur.right);
            if(cur.left != null)
                stack.Push(cur.left);
            if(stack.Count > 0)
                cur.right = stack.Peek();
            cur.left = null;
        }
    }
}
