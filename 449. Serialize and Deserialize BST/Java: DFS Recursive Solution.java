/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    // 时间复杂度O(n)，空间复杂度O(n)
    public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) 
    {
        // 和建立二叉树不同的是在建立二叉搜索数时不编码空节点，
        // 这样可以使编码后的字符串更紧凑
        if(node == null) 
            return;
        else 
        {
            sb.append(node.val + ",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
	// 时间复杂度O(nlogn)，空间复杂度O(n)
	public TreeNode deserialize(String data)
	{
	    if(data.isEmpty())
	        return null;
		Queue<Integer> nodes = new LinkedList<Integer>();
		for(String node : data.split(","))
		{
		    nodes.offer(Integer.parseInt(node));
		}
		return buildTree(nodes);
	}
    
    private TreeNode buildTree(Queue<Integer> nodes) 
    {
        // 叶子节点的左右子树为空
        if(nodes.isEmpty()) 
            return null;
        int cur = nodes.poll();
        TreeNode root = new TreeNode(cur);
        Queue<Integer> left = new LinkedList();
        // 把所有的比当前节点小的节点放入left队列，这些节点都是属于当前节点的左子树的，
        // 剩下的节点都属于右子树
        while(!nodes.isEmpty() && nodes.peek() < cur) 
        {
            left.offer(nodes.poll());
        }
        // 建立左子树，传入的是left
        root.left = buildTree(left);
        // 建立右子树，传入的是nodes
        root.right = buildTree(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
