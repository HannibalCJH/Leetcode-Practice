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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        // 奇数层的栈
        Stack<TreeNode> oddLevel = new Stack<TreeNode>();
        // 偶数层的栈
        Stack<TreeNode> evenLevel = new Stack<TreeNode>();
        // 把根节点压入奇数层的栈
        oddLevel.push(root);
        while(!oddLevel.isEmpty() || !evenLevel.isEmpty())
        {
            List<Integer> cur = new ArrayList<Integer>();
            // 奇数层
            if(!oddLevel.isEmpty())
            {
                while(!oddLevel.isEmpty())
                {
                    TreeNode node = oddLevel.pop();
                    cur.add(node.val);
                    // 先加左节点
                    if(node.left != null)
                        evenLevel.push(node.left);
                    // 后加右节点
                    if(node.right != null)
                        evenLevel.push(node.right);
                }
            }
            else
            {
                // 偶数层
                while(!evenLevel.isEmpty())
                {
                    TreeNode node = evenLevel.pop();
                    cur.add(node.val);
                    // 先加右节点
                    if(node.right != null)
                        oddLevel.push(node.right);
                    // 后加左节点
                    if(node.left != null)
                        oddLevel.push(node.left);
                }
            }
            result.add(cur);
        }
        return result;
    }
}
