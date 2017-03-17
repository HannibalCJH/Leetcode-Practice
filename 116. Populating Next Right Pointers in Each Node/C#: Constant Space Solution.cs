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
        TreeLinkNode nextLevel = cur.left;
        // 当下一层的节点不为空
        while(nextLevel != null)
        {
            // 当前左节点的next指针指向右节点
            cur.left.next = cur.right;
            // 如果当前节点还不是这一层的最后一个节点，
            // 则当前节点右节点的next指针指向这一层下一个节点的左节点
            if(cur.next != null)
            {
                cur.right.next = cur.next.left;
                cur = cur.next;
            }
            else
            {
                // 如果到了这一层的最后一个节点，把cur指向下一层的第一个节点
                cur = nextLevel;
                // 更新下一层的第一个节点
                nextLevel = cur.left;
            }
        }
    }
}
