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
    public IList<int> RightSideView(TreeNode root) 
    {
        IList<int> result = new List<int>();
        if(root == null)
            return result;
        
        bool firstOfLevel;
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        while(queue.Count > 0)
        {
            firstOfLevel = true;
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.Dequeue();
                if(firstOfLevel)
                {
                    result.Add(node.val);
                    firstOfLevel = false;
                }
                
                if(node.right != null)
                    queue.Enqueue(node.right);
                if(node.left != null)
                    queue.Enqueue(node.left);
            }
        }
        return result;
    }
}
