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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        dfs(result, root);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode node)
    {
        if(node == null)
            return;
        dfs(result, node.left);
        result.add(node.val);
        dfs(result, node.right);
    }
}
