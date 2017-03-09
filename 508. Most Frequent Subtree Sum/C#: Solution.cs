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
    int maxCount = 0;
    Dictionary<int, int> map = new Dictionary<int, int>();
    
    public int[] FindFrequentTreeSum(TreeNode root) 
    {
        if(root == null)
            return new int[0];
            
        DFS(root);
        List<int> list = new List<int>();
        foreach(int key in map.Keys)
        {
            int count = map[key];
            if(count == maxCount)
            {
                list.Add(key);
            }
        }
        
        int[] result = new int[list.Count];
        int index = 0;
        foreach(int sum in list)
        {
            result[index++] = sum;
        }
        return result;
    }
    
    private int DFS(TreeNode node)
    {
        if(node == null)
            return 0;
            
        int left = DFS(node.left);
        int right = DFS(node.right);
        int treeSum = left + right + node.val;
        if(map.ContainsKey(treeSum))
        {
            map[treeSum]++;
        }
        else
        {
            map.Add(treeSum, 1);
        }
        
        maxCount = Math.Max(map[treeSum], maxCount);
        return treeSum;
    }
}
