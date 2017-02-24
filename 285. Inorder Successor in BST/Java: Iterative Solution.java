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
    // BST中序遍历是递增序列
    // 时间复杂度O(logn)，空间复杂度O(logn)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) 
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 找节点p
        while(root != p)
        {
            stack.push(root);
            if(root.val > p.val)
                root = root.left;
            else
                root = root.right;
        }
        
        // 如果有右子树，下一个节点就是右子树中最左边的节点
        if(root.right != null)
        {
            root = root.right;
            while(root.left != null)
                root = root.left;
            return root;
        }
        else
        {
            // 右子树为空，那下一个节点就是往回找直到找到第一个比p大的节点就是要找的节点
            // 因为BST中序遍历是递增序列，下一个节点肯定是比p要大
            while(!stack.isEmpty() && stack.peek().val < p.val)
                stack.pop();
            return stack.isEmpty() ? null : stack.pop();
        }
    }
}
