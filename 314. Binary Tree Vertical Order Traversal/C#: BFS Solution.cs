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
    public IList<IList<int>> VerticalOrder(TreeNode root) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(root == null)
            return result;
        
        Dictionary<int, IList<int>> map = new Dictionary<int, IList<int>>();
        Queue<TreeNode> queue = new Queue<TreeNode>();
        Queue<int> columns = new Queue<int>();
        queue.Enqueue(root);
        columns.Enqueue(0);
        int min = 0, max = 0;
        
        while(queue.Count > 0)
        {
            TreeNode node = queue.Dequeue();
            int col = columns.Dequeue();
            if(!map.ContainsKey(col))
            {
                map.Add(col, new List<int>());
            }
            map[col].Add(node.val);
            
            min = Math.Min(col, min);
            max = Math.Max(col, max);
            
            if(node.left != null)
            {
                queue.Enqueue(node.left);
                columns.Enqueue(col - 1);
            }
            
            if(node.right != null)
            {
                queue.Enqueue(node.right);
                columns.Enqueue(col + 1);
            }
        }
        
        for(int i = min; i <= max; i++)
        {
            result.Add(map[i]);
        }
        return result;
    }
}
