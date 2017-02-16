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
    int preStart;
    
    public TreeNode BuildTree(int[] preorder, int[] inorder) 
    {
        if(preorder == null || preorder.Length == 0)
            return null;
        
        preStart = 0;
        return Construct(preorder, inorder, 0, inorder.Length - 1);
    }
    
    private TreeNode Construct(int[] preorder, int[] inorder, int inStart, int inEnd)
    {
        if(preStart == preorder.Length || inStart > inEnd)
            return null;
            
        TreeNode node = new TreeNode(preorder[preStart++]);
        int inMid;
        for(inMid = inStart; inMid < inEnd; inMid++)
        {
            if(inorder[inMid] == node.val)
                break;
        }
        
        node.left = Construct(preorder, inorder, inStart, inMid - 1);
        node.right = Construct(preorder, inorder, inMid + 1, inEnd);
        return node;
    }
}
