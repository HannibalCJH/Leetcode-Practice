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
    // DFS先序遍历，空节点用#表示
    // 时间复杂度O(n)，空间复杂度O(h)其中h为树的高度
    public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) 
    {
        if(node == null) 
        {
            sb.append("#,");
        } 
        else 
        {
            sb.append(node.val + ",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    // 时间复杂度O(n)，空间复杂度O(n)
    public TreeNode deserialize(String data)
    {
        if(data.isEmpty())
            return null;
        Queue<String> nodes = new LinkedList<String>();
        for(String node : data.split(","))
        {
            nodes.offer(node);
        }
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes)
    {
        // 取得节点的值
        String val = nodes.poll();
        if(val.equals("#"))
            return null;
        else
        {
            // 创建当前节点
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
