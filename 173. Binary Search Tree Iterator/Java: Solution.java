/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) 
    {
        stack = new Stack<TreeNode>();
        // 初始化，一直把左节点压人栈
        // 栈顶即为下一个最小节点
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    
    // 时间复杂度O(1)，空间复杂度O(h)，h为树的高度
    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return !stack.isEmpty();    
    }
    
    // 平均时间复杂度O(1)，next()函数遍历一遍所有的节点总的时间为O(n)，但是我们一次call只往后找一个，
    // 要找call总共为n次才能遍历完，所以平均时间复杂度O(1)
    // 空间复杂度O(h)
    /** @return the next smallest number */
    public int next() 
    {
        // 栈顶即为下一个最小节点
        TreeNode node = stack.pop();
        int result = node.val;
        // 如果有右节点，就一直把其左节点压人栈
        if(node.right != null)
        {
            node = node.right;
            while(node != null)
            {
                stack.push(node);
                node = node.left;
            }
        }
        
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
