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
    int maxLevel = 0;
    
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        dfs(result, root, 1);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode node, int level)
    {
        if(node == null)
            return;
        // 比全局最深的层还要深就加入结果集
        if(level > maxLevel)
        {
            result.add(node.val);
            maxLevel = level;
        }
        // 先右子树后左子树，这样能够保证先到达下一层的最右边
        dfs(result, node.right, level + 1);
        dfs(result, node.left, level + 1);
    }
}
