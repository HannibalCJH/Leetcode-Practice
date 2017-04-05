public class Solution {
    // 时间复杂度O(n+m)，n为节点个数，m为边的数目。
    // 初始化邻接表O(m)，然后DFS最多遍历一遍所有的节点，对于已经被遍历的就形成了环立刻返回true，时间为O(n)
    // 两个步骤互不干扰，所以相加是O(n+m)
    // 空间复杂度O(n)
    public boolean validTree(int n, int[][] edges) 
    {
        if(edges.length != n - 1)
            return false;
        // 邻接链表存节点
        List<Integer>[] adjList = new List[n];
        // 初始化每个节点
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<Integer>();
        // 遍历所有的边，把每个节点的邻居节点加入这个节点的链表
        // 注意是无向图，两个方向都加
        for(int[] edge : edges)
        {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        // 有环
        if(hasCycle(adjList, -1, 0, visited))
            return false;
        // 检查是否有没被访问过的节点，如果有则不止一个连通部分
        for(int i = 0; i < n; i++)
            if(!visited[i])
                return false;
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] adjList, int pre, int cur, boolean[] visited)
    {
        List<Integer> nextList = adjList[cur];
        // 当前节点被访问，设为1
        visited[cur] = true;
        // 遍历当前节点的邻节点
        for(int next : nextList)
        {
            // 排除当前节点的前置节点，因为是无向图，所以要避免往回走
            if(next != pre)
            {
                // 1. 发现已经被访问过的节点，形成了环
                // 2. 对未被访问过的节点进行递归
                if(visited[next] || hasCycle(adjList, cur, next, visited))
                    return true;
            }
        }
        return false;
    }
}
