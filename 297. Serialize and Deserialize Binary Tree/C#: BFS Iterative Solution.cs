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
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        while(queue.Count != 0)
        {
            TreeNode cur = queue.Dequeue();
            if(cur == null)
            {
                sb.Append("#,");
            }
            else
            {
                sb.Append(cur.val + ",");
                queue.Enqueue(cur.left);
                queue.Enqueue(cur.right);
            }
        }
        return sb.ToString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data)
    {
        if(data == null || data.Length == 0)
            return null;
        // 传入的data是"1,1,#,#,"，最后又逗号
        // 如果不加RemoveEmptyEntries则最后会有一个空字符串
        string[] vals = data.Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);
        int[] nullNum = new int[vals.Length];
        TreeNode[] nodes = new TreeNode[vals.Length];
        // 第一遍记录每个节点之前的空节点个数
        for(int i = 0; i < vals.Length; i++)
        {
            if(i > 0)
                nullNum[i] = nullNum[i - 1];

            if(vals[i].Equals("#"))
            {
                nullNum[i]++;
                nodes[i] = null;
            }
            else
            {
                nodes[i] = new TreeNode(Convert.ToInt32(vals[i]));
            }
        }

        // 第二遍重建二叉树
        for(int i = 0; i < vals.Length; i++)
        {
            if (nodes[i] == null)
                continue;
            nodes[i].left = nodes[(i - nullNum[i]) * 2 + 1];
            nodes[i].right = nodes[(i - nullNum[i]) * 2 + 2];
        }
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
