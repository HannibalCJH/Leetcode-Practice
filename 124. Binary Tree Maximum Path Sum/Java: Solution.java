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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) 
    {
        maxSum(root);
        return max;
    }
    
    public int maxSum(TreeNode node) 
    {
        if(node == null) 
            return 0;
        // 递归求左支路的最大路径和
        int leftVal = maxSum(node.left);
        // 递归求右支路的最大路径和
        int rightVal = maxSum(node.right);  
        
        // 如果当前局部解(node或left+node或node+right或left+node+right)是最优解，更新最终结果
        int curMax = node.val;
        if(leftVal > 0)
            curMax += leftVal;
        if(rightVal > 0)
            curMax += rightVal;
        if(curMax > max)
            max = curMax;
        // 返回从叶子结点到node的最大路径之和(node或left+node或node+right)
        // 注意这里不能返回left+node+right，因为这会造成路径分叉，我们要求的是一条路径不能有分叉
        // 所以只能是左子树往上走或是右子树往上走，不能同时走两个分支
        return Math.max(node.val, Math.max(node.val + leftVal, node.val + rightVal));
    }
}
