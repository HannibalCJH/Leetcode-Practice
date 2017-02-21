/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 记录对应节点的信息
class Node
{
    boolean isBST;
    int max;
    int min;
    int size;
    public Node()
    {
        isBST = false;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        size = 0;
    }
}
 
public class Solution {
    // 时间复杂度O(n)，每个节点只需遍历一次
    // 空间复杂度O(n)，每个节点都会生成一个对应Node类的实例
    int result;
    
    public int largestBSTSubtree(TreeNode root) 
    {
        result = 0;
        dfs(root);
        return result;
    }
    
    private Node dfs(TreeNode node)
    {
        Node cur = new Node();
        // 空节点认为是BST
        if(node == null)
        {
            cur.isBST = true;
            return cur;
        }
        // 自底向上，先遍历左右子树
        Node left = dfs(node.left);
        Node right = dfs(node.right);
        
        // 左右子树都是BST且当前节点和左右子树也构成了BST
        if(left.isBST && right.isBST && node.val > left.max && node.val < right.min)
        {
            // 标识当前子树为BST
            cur.isBST = true;
            // 当前子树的大小是其左右子树再加本身的节点数
            cur.size = left.size + right.size + 1;
            // 左子树为空则left.min是最大整数，这个时候node是子树中最小的值
            cur.min = Math.min(node.val, left.min);
            // 右子树为空则right.max是小大整数，这个时候node是子树中最大的值
            cur.max = Math.max(node.val, right.max);
            // 更新全局最大值
            if(cur.size > result)
                result = cur.size;
        }
        return cur;
    }
}
