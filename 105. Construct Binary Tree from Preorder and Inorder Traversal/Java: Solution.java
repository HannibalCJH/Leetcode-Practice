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
    // 时间复杂度O(n^2)
    // 空间复杂度O(n)
    int preStart;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        if(preorder == null)
            return null;
            
        preStart = 0;
        return construct(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int[] inorder, int inStart, int inEnd)
    {
        // 遍历完所有节点或者已经是叶节点
        if(preStart == preorder.length || inStart > inEnd)
            return null;
            
        // 创建根节点
        TreeNode cur = new TreeNode(preorder[preStart++]);
        int index;
        for(index = inStart; index < inEnd; index++)
        {
            if(inorder[index] == cur.val)
                break;
        }
        
        cur.left = construct(preorder, inorder, inStart, index - 1);
        cur.right = construct(preorder, inorder, index + 1, inEnd);
        
        return cur;
    }
}
