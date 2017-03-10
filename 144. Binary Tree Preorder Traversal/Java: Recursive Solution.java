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
    // 时间复杂度O(n)，空间复杂度O(n)
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        if(root != null)
        {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }
}
