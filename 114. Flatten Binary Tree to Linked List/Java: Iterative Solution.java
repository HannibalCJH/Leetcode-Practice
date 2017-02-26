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
    // 迭代法
    // 时间复杂度O(n)，空间复杂度O(n)
    public void flatten(TreeNode root) 
    {
        if(root == null)
            return;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        // 先序遍历
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pop();
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
            // 当前节点的右子树为先序遍历的下一个节点也就是栈顶节点
            if(!stack.isEmpty())
                cur.right = stack.peek();
            // 记得把当前节点的左子树设成空
            cur.left = null;
        }
    }
}
