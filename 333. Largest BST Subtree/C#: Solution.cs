/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
 
class Node
{
    public bool isBST;
    public int max;
    public int min;
    public int size;
    public Node()
    {
        isBST = false;
        max = Int32.MinValue;
        min = Int32.MaxValue;
        size = 0;
    }
}
 
public class Solution {
    int result;
    
    public int LargestBSTSubtree(TreeNode root) 
    {
        result = 0;
        DFS(root);
        return result;
    }
    
    private Node DFS(TreeNode node)
    {
        Node cur = new Node();
        if(node == null)
        {
            cur.isBST = true;
            return cur;
        }
        
        Node left = DFS(node.left);
        Node right = DFS(node.right);
        
        if(left.isBST && right.isBST && node.val > left.max && node.val < right.min)
        {
            cur.isBST = true;
            cur.max = Math.Max(node.val, right.max);
            cur.min = Math.Min(node.val, left.min);
            cur.size = left.size + right.size + 1;
            if(cur.size > result)
                result = cur.size;
        }
        return cur;
    }
}
