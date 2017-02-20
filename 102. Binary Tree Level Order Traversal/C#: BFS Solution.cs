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
    public IList<IList<int>> LevelOrder(TreeNode root) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        while(queue.Count != 0)
        {
            IList<int> curLevel = new List<int>();
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.Dequeue();
                curLevel.Add(node.val);
                if(node.left != null)
                    queue.Enqueue(node.left);
                if(node.right != null)
                    queue.Enqueue(node.right);
            }
            result.Add(curLevel);
        }
        return result;
    }
}
