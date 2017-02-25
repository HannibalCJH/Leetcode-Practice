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
    // 迭代法
    // 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
    
        while(cur != null || !stack.isEmpty())
        {
            // 一直往左搜索，把所有左边的节点压入栈
            if(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                // 弹出一个节点
                cur = stack.pop();
                // 加入结果
                result.add(cur.val);
                // 往这个节点的右子树走
                cur = cur.right;
            }
        }
        return result;
    }
}
