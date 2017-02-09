/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        BuildString(root, sb);
        return sb.ToString();
    }

    private void BuildString(TreeNode node, StringBuilder sb) 
    {
        if(node == null) 
        {
            sb.Append("#,");
        } 
        else 
        {
            sb.Append(node.val + ",");
            BuildString(node.left, sb);
            BuildString(node.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data)
    {
		if(data.Length == 0)
			return null;
        Queue<string> nodes = new Queue<string>();
        foreach(string node in data.Split(new char[]{','}, StringSplitOptions.RemoveEmptyEntries))
	{
            nodes.Enqueue(node);
        }
        return BuildTree(nodes);
    }

    private TreeNode BuildTree(Queue<string> nodes)
    {
        string val = nodes.Dequeue();
        if(val.Equals("#"))
            return null;
        else
        {
            TreeNode node = new TreeNode(Int32.Parse(val));
            node.left = BuildTree(nodes);
            node.right = BuildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
