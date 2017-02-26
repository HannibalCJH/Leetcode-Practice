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
    // 迭代法，每次修改节点的值，也可以用另一个栈记录相加的值这样就不用修改节点本身
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        if(root == null)
            return false;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            root = stack.pop();
            if(root.left == null && root.right == null && root.val == sum)
                return true;
            // 先右子树再左子树
            if(root.right != null)
            {
                root.right.val += root.val;
                stack.push(root.right);
            }
            
            if(root.left != null)
            {
                root.left.val += root.val;
                stack.push(root.left);
            }
        }
        return false;
    }
}
