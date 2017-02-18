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
    // BFS扫一遍，空字符用#表示
    // 时间复杂度O(n)，空间复杂度O(n)
    public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // BFS
        while(!queue.isEmpty())
        {
            TreeNode cur = queue.poll();
            if(cur == null)
            {
                sb.append("#,");
            }
            else
            {
                sb.append(String.valueOf(cur.val) + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // 时间复杂度O(n)，空间复杂度O(n)
    public TreeNode deserialize(String data) 
    {
        if(data.isEmpty())
            return null;
        
        String[] vals = data.split(",");
        // 记录每个节点之前有多少个空节点
        int[] nullNum = new int[vals.length];
        TreeNode[] nodes = new TreeNode[vals.length];
        // 先扫一遍，统计每个节点之前有多少个空节点并建立树的节点
        for(int i = 0; i < vals.length; i++)
        {
            // 初始化为上一个节点的记录
            if(i > 0)
                nullNum[i] = nullNum[i-1];
            if(vals[i].equals("#"))
            {
                nullNum[i]++;
                nodes[i] = null;
            }
            else
            {
                nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
            }
        }
        
        // 第二遍开始重建二叉树
        for(int i = 0; i < vals.length; i++)
        {
            if(nodes[i] == null)
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
