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
    Dictionary<int, int> map = new Dictionary<int, int>();
    
    public TreeNode BuildTree(int[] preorder, int[] inorder) 
    {
        if(preorder == null || preorder.Length == 0)
            return null;
        
        preStart = 0;
        for(int i = 0; i < inorder.Length; i++)
            map.Add(inorder[i], i);
            
        return Construct(preorder, inorder, 0, inorder.Length - 1);
    }
    
    private TreeNode Construct(int[] preorder, int[] inorder, int inStart, int inEnd)
    {
        if(preStart == preorder.Length || inStart > inEnd)
            return null;
            
        TreeNode node = new TreeNode(preorder[preStart++]);
        int inMid = map[node.val];
        
        node.left = Construct(preorder, inorder, inStart, inMid - 1);
        node.right = Construct(preorder, inorder, inMid + 1, inEnd);
        return node;
    }
}
