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
    // 时间复杂度O(n)，遍历所有节点
    // 空间复杂度O(h)，h为树的高度
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> result = new ArrayList<String>();
        if(root == null)
        {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, root);
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder cur, TreeNode node)
    {
        // 先加节点
        cur.append(node.val);
        // 叶节点
        if(node.left == null && node.right == null)
        {
            result.add(cur.toString());
            return;
        }
        cur.append("->");
        int length = cur.length();
        if(node.left != null)
            dfs(result, cur, node.left);
        // 回溯
        cur.setLength(length);
        if(node.right != null)
            dfs(result, cur, node.right);
    }
}
