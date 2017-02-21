/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     public int val;
 *     public TreeLinkNode left, right, next;
 *     public TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 每次建立的是当前层的下一层的next节点，可以利用next指针
    // 时间复杂度O(n)，空间复杂度O(logn)，满二叉树的树高是logn
    public void Connect(TreeLinkNode root) 
    {
        // 不是最后一层叶节点或是空节点
        if(root == null || root.left == null)
            return;

        // 左节点的next指针指向右节点
        root.left.next = root.right;
        // 这一层的next节点已经在上一层的时候建立好
        if(root.next != null)
            root.right.next = root.next.left;
        
        Connect(root.left);
        Connect(root.right);
    }
}
