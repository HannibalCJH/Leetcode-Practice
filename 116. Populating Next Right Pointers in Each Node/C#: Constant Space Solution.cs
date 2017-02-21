/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     public int val;
 *     public TreeLinkNode left, right, next;
 *     public TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void Connect(TreeLinkNode root) 
    {
        if(root == null)
            return;
            
        // 当前层的节点
        TreeLinkNode cur = root;
        // 下一层的第一个节点
        TreeLinkNode head = root.left;
        while(cur.left != null)
        {
            while(cur != null)
            {
                // 设置下一层的第一个节点
                if(head == null)
                    head = cur.left;
                // 当前左节点的next指针指向右节点
                cur.left.next = cur.right;
                // 如果当前节点还不是这一层的最后一个节点，
                // 则当前节点右节点的next指针指向当前这次下一个节点的左节点
                if(cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            // 移动到下一层的第一个节点
            cur = head;
            head = null;
        }
    }
}
