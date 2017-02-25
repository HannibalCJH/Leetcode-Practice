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
    public bool IsSymmetric(TreeNode root) 
    {
        if(root == null)
            return true;
            
        Queue<TreeNode> lTree = new Queue<TreeNode>();
        Queue<TreeNode> rTree = new Queue<TreeNode>();
        lTree.Enqueue(root.left);
        rTree.Enqueue(root.right);
        
        while(lTree.Count > 0 && rTree.Count > 0)
        {
            TreeNode lNode = lTree.Dequeue(), rNode = rTree.Dequeue();
            if(lNode == null && rNode == null)
                continue;
            if(lNode == null || rNode == null || lNode.val != rNode.val)
                return false;
            lTree.Enqueue(lNode.left);
            lTree.Enqueue(lNode.right);
            rTree.Enqueue(rNode.right);
            rTree.Enqueue(rNode.left);
        }
        return lTree.Count == 0 && rTree.Count == 0;
    }
}
