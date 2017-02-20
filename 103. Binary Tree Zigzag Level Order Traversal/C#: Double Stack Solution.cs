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
    public IList<IList<int>> ZigzagLevelOrder(TreeNode root) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(root == null)
            return result;
        
        Stack<TreeNode> oddLevel = new Stack<TreeNode>();
        Stack<TreeNode> evenLevel = new Stack<TreeNode>();
        oddLevel.Push(root);
        
        while(oddLevel.Count > 0 || evenLevel.Count > 0)
        {
            IList<int> cur = new List<int>();
            if(oddLevel.Count > 0)
            {
                while(oddLevel.Count > 0)
                {
                    TreeNode node = oddLevel.Pop();
                    cur.Add(node.val);
                    if(node.left != null)
                        evenLevel.Push(node.left);
                    if(node.right != null)
                        evenLevel.Push(node.right);
                }
            }
            else
            {
                while(evenLevel.Count > 0)
                {
                    TreeNode node = evenLevel.Pop();
                    cur.Add(node.val);
                    if(node.right != null)
                        oddLevel.Push(node.right);
                    if(node.left != null)
                        oddLevel.Push(node.left);
                }
            }
            result.Add(cur);
        }
        return result;
    }
}
