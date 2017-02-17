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
    public IList<string> BinaryTreePaths(TreeNode root) 
    {
        IList<string> result = new List<string>();
        if(root == null)
            return result;
        StringBuilder sb = new StringBuilder();
        DFS(result, sb, root);
        return result;
    }
    
    private void DFS(IList<string> result, StringBuilder cur, TreeNode node)
    {
        cur.Append(node.val);
        // 叶节点
        if(node.left == null && node.right == null)
        {
            result.Add(cur.ToString());
            return;
        }
        
        cur.Append("->");
        int length = cur.Length;
        if(node.left != null)
            DFS(result, cur, node.left);
        // 回溯
        cur.Length = length;
        if(node.right != null)
            DFS(result, cur, node.right);
    }
}
