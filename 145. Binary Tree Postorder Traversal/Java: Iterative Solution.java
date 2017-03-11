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
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
	public List<Integer> postorderTraversal(TreeNode root) 
	{
	    if(root == null)
            return new ArrayList<Integer>();
        
        // 用双向链表，头尾都可以操作
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 遍历时把先序遍历顺序完全倒过来，先序遍历是把遇到的节点先加入结果，正常的顺序为加到原来链表的最后
        // 那我们后续的遍历就是把遇到的节点最后加入，即加到链表的头部，但这样输出就变成"右->左->父"的顺序，
        // 所以我们再把先序遍历中左和右的位置颠倒就能够输出"左->右->父"
        while(root != null || !stack.isEmpty())
        {
            if(root != null)
            {
                // 颠倒先序遍历中节点加入到链表的位置，每次加到头节点
                result.addFirst(root.val);
                stack.push(root);
                // 颠倒先序遍历中左右节点的顺序，先遍历右子树
                root = root.right;
            }
            else
            {
                root = stack.pop();
                // // 颠倒先序遍历中左右节点的顺序，后遍历左子树
                root = root.left;
            }
        }
        return result;
	}
}
