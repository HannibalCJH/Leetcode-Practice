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
    // 时间复杂度O(n)，空间复杂度O(n)
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        if(root == null)
            return new ArrayList<Integer>();
            
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            result.add(node.val);
            // 因为是压入栈，所以先右子树后左子树，这样在弹出时我们先遍历的是左子树然后再右子树
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return result;
    }
}
