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
    int maxLevel = 0;
    
    public IList<int> RightSideView(TreeNode root) 
    {
        IList<int> result = new List<int>();
        DFS(result, root, 1);
        return result;
    }
    
    private void DFS(IList<int> result, TreeNode node, int level)
    {
        if(node == null)
            return;
            
        if(level > maxLevel)
        {
            result.Add(node.val);
            maxLevel = level;
        }
        DFS(result, node.right, level + 1);
        DFS(result, node.left, level + 1);
    }
}
