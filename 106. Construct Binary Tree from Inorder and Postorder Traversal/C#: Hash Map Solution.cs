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
    public int postEnd;
    Dictionary<int, int> map = new Dictionary<int, int>();
    
    public TreeNode BuildTree(int[] inorder, int[] postorder) 
    {
        if(postorder == null)
            return null;
        postEnd = postorder.Length - 1;
        for(int i = 0; i < inorder.Length; i++)
            map.Add(inorder[i], i);
            
        return Construct(inorder, postorder, 0, inorder.Length - 1);
    }
    
    private TreeNode Construct(int[] inorder, int[] postorder, int inStart, int inEnd)
    {
        if(postEnd < 0 || inStart > inEnd)
            return null;
            
        TreeNode cur = new TreeNode(postorder[postEnd--]);
        int index = map[cur.val];

        // 右子树
        cur.right = Construct(inorder, postorder, index + 1, inEnd);
        // 左子树
        cur.left = Construct(inorder, postorder, inStart, index - 1);
        
        return cur;
    }
}
