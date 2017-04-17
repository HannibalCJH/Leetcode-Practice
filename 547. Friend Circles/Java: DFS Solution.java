public class Solution {
    // 其实就是寻找一个无向图有多少个连通部分
    // 时间复杂度O(n^2)，矩形中的每个元素最多只会深度优先遍历一次，然后就设成访问过，不再重复遍历
    // 空间复杂度O(n)，递归栈深度最大为n
    public int findCircleNum(int[][] M) 
    {
        if(M == null || M.length == 0 || M[0].length == 0)
            return 0;
        
        int count = 0, n = M.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            // 这个节点没有被访问过，说明又是另一个连通部分，不然在前面节点的递归中应该已经被访问过
            if(!visited[i])
            {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] M, int cur, boolean[] visited)
    {
        if(visited[cur])
            return;
        
        visited[cur] = true;
        // 递归遍历当前节点的所有邻居节点
        for(int i = 0; i < M.length; i++)
        {
            if(i == cur)
                continue;
            if(M[pre][i] == 1)
                dfs(M, i, visited);
        }
    }
}
