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
    public int SumOfLeftLeaves(TreeNode root) 
    {
        if(root == null)
            return 0;
        // 记录节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 记录节点是不是左节点
        Stack<bool> flags = new Stack<bool>();
        stack.Push(root);
        flags.Push(false);
        int sum = 0;
        while(stack.Count > 0)
        {
            TreeNode node = stack.Pop();
            bool flag = flags.Pop();
            if(flag && node.left == null && node.right == null)
            {
                sum += node.val;
                continue;
            }
            if(node.right != null)
            {
                stack.Push(node.right);
                flags.Push(false);
            }
            if(node.left != null)
            {
                stack.Push(node.left);
                flags.Push(true);
            }
        }
        return sum;    
    }
}
