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
    // 时间复杂度O(n)，需要遍历一遍所有的元素创建对应的树的节点
    // 空间复杂度O(n)，主要是哈希表
    int preStart;
    // 用哈希表来存中序遍历中的值和对应的下标
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        if(preorder == null)
            return null;
        preStart = 0;
        
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return construct(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int[] inorder, int inStart, int inEnd)
    {
        // 遍历完所有节点或者已经是叶节点
        if(preStart == preorder.length || inStart > inEnd)
            return null;
            
        // 创建根节点
        TreeNode cur = new TreeNode(preorder[preStart++]);
        int index = map.get(cur.val);
        
        cur.left = construct(preorder, inorder, inStart, index - 1);
        cur.right = construct(preorder, inorder, index + 1, inEnd);
        
        return cur;
    }
}
