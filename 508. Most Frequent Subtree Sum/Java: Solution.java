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
    // 记录最大的count
    int maxCount = 0;
    // 哈希表存[sum, count]
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int[] findFrequentTreeSum(TreeNode root) 
    {
        if(root == null)
            return new int[0];
        
        dfs(root);
        List<Integer> list = new ArrayList<Integer>();
        // 用list把所有count为最大count的sum存起来
        for(int key : map.keySet())
        {
            int count = map.get(key);
            if(count == maxCount)
            {
                list.add(key);
            }
        }
        // 根据list的长度来决定数组的长度
        int[] result = new int[list.size()];
        int index = 0;
        // 把list的内容导入数组
        for(int sum : list)
        {
            result[index++] = sum;
        }
        return result;
    }
    
    // 后续遍历DFS
    private int dfs(TreeNode node)
    {
        if(node == null)
            return 0;
        // 左子树的值
        int left = dfs(node.left);
        // 右子树的值
        int right = dfs(node.right);
        // 当前子树的值
        int treeSum = left + right + node.val;
        // 更新哈希表
        if(map.containsKey(treeSum))
        {
            map.put(treeSum, map.get(treeSum) + 1);
        }
        else
        {
            map.put(treeSum, 1);
        }
        // 更新最大的count
        maxCount = Math.max(map.get(treeSum), maxCount);
        // 返回当前子树的值
        return treeSum;
    }
}
