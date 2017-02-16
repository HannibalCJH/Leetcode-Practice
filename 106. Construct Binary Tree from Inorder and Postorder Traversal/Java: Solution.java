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
    // 时间复杂度O(n^2)，空间复杂度O(n)
    int postEnd;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        if(postorder == null)
            return null;
        postEnd = postorder.length - 1;
        return construct(inorder, postorder, 0, inorder.length - 1);    
    }
    
    private TreeNode construct(int[] inorder, int[] postorder, int inStart, int inEnd)
    {
        // 遍历完所有节点或者已经是叶节点
        if(postEnd < 0 || inStart > inEnd)
            return null;
        
        // 创建根节点
        TreeNode cur = new TreeNode(postorder[postEnd--]);
        int index;
        // 找到根在中序序列中的位置，从而知道后序中的分割点
        for(index = inStart; index < inEnd; index++)
        {
            if(inorder[index] == cur.val)
                break;
        }
        
        // 先右子树，因为我们是倒着取postorder里的节点，先碰到的是右子树的节点
        cur.right = construct(inorder, postorder, index + 1, inEnd);
        // 后左子树
        cur.left = construct(inorder, postorder, inStart, index - 1);
        
        return cur;
    }
}
