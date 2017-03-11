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
        while(root != null || !stack.isEmpty())
        {
            if(root != null)
            {
                // 先序遍历先把当前节点加上
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            else
            {
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }
}
