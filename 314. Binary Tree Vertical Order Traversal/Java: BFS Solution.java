/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public List<List<Integer>> verticalOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        // 哈希表记录[列数，对应这一列的元素]
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // 作为BFS的队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 记录queue中对应节点的列数
        Queue<Integer> columns = new LinkedList<Integer>();
        queue.offer(root);
        columns.offer(0);
        // 分别记录最小和最大的列数
        int min = 0, max = 0;
        
        // BFS
        while(!queue.isEmpty())
        {
            // 取得节点和对应所在的列数
            TreeNode node = queue.poll();
            int col = columns.poll();
            // 更新最小和最大列数
            min = Math.min(col, min);
            max = Math.max(col, max);
            // 把当前节点所在的列和节点值加入哈希表
            if(!map.containsKey(col))
            {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
            
            // 左节点列数减1
            if(node.left != null)
            {
                queue.offer(node.left);
                columns.offer(col - 1);
            }
            // 右节点列数加1
            if(node.right != null)
            {
                queue.offer(node.right);
                columns.offer(col + 1);
            }
        }
        // 从最小列数到最大列数进行扫描
        for(int i = min; i <= max; i++)
        {
            result.add(map.get(i));
        }
        return result;
    }
}
