/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    public int sumOfLeftLeaves(TreeNode root) 
    {
        if(root == null)
            return 0;
        // 记录节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 记录节点是不是左节点
        Stack<Boolean> flags = new Stack<Boolean>();
        stack.push(root);
        flags.push(false);
        int sum = 0;
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            boolean flag = flags.pop();
            if(flag && node.left == null && node.right == null)
            {
                sum += node.val;
                continue;
            }
            if(node.right != null)
            {
                stack.push(node.right);
                flags.push(false);
            }
            if(node.left != null)
            {
                stack.push(node.left);
                flags.push(true);
            }
        }
        return sum;
    }
}
