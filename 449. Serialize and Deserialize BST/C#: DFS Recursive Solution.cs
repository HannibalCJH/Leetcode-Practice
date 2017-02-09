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
    // DFS先序遍历
    private void BuildString(TreeNode node, StringBuilder sb)
    {
        // 不编码空节点
        if(node == null)
            return;
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
        if(data == null || data.Length == 0)
            return null;
            
        Queue<int> nodes = new Queue<int>();
        foreach(string node in data.Split(new char[]{','}, StringSplitOptions.RemoveEmptyEntries))
        {
            nodes.Enqueue(Int32.Parse(node));
        }
        return BuildTree(nodes);
    }
    
    private TreeNode BuildTree(Queue<int> nodes)
    {
        // 叶节点的左右子树为空节点
        if(nodes.Count == 0)
            return null;
            
        TreeNode cur = new TreeNode(nodes.Dequeue());
        Queue<int> left = new Queue<int>();
        while(nodes.Count != 0 && nodes.Peek() < cur.val)
        {
            left.Enqueue(nodes.Dequeue());
        }
        
        cur.left = BuildTree(left);
        cur.right = BuildTree(nodes);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
