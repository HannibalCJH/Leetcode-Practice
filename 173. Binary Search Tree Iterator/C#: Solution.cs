/**
 * Definition for binary tree
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) 
    {
        stack = new Stack<TreeNode>();
        while(root != null)
        {
            stack.Push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public bool HasNext() 
    {
        return stack.Count > 0;    
    }

    /** @return the next smallest number */
    public int Next() 
    {
        TreeNode node = stack.Pop();
        int result = node.val;
        if(node.right != null)
        {
            node = node.right;
            while(node != null)
            {
                stack.Push(node);
                node = node.left;
            }
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.HasNext()) v[f()] = i.Next();
 */
