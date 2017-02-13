public class Solution {
    // 时间复杂度O(n+m)，n为节点个数，m为边的数目。
    // 初始化邻接表O(m)，然后DFS最多遍历一遍所有的节点，对于已经被遍历的就形成了环立刻返回true，时间为O(n)
    // 两个步骤互不干扰，所以相加是O(n+m)
    // 空间复杂度O(n)
    public boolean validTree(int n, int[][] edges) 
    {
        int[] visited = new int[n];
        // 邻接链表存节点
        List<List<Integer>> adjList = new ArrayList<>();
        // 初始化每个节点
        for(int i = 0; i < n; i++) 
            adjList.add(new ArrayList<Integer>());
        // 遍历所有的边，把每个节点的邻居节点加入这个节点的链表
        // 注意是无向图，两个方向都加
        for(int[] edge: edges) 
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        // 有环
        if(hasCycle(-1, 0, visited, adjList)) 
            return false;
        // 检查是否有没被访问过的节点，如果有则不止一个连通部分
        for(int v : visited) 
        { 
            if(v == 0)
                return false;
        }
        return true;
    }
    
    private boolean hasCycle(int pred, int vertex, int[] visited, List<List<Integer>> adjList)
    {
        // 当前节点被访问，设为1
        visited[vertex] = 1;
        // 遍历当前节点的邻节点
        for(Integer neighbor: adjList.get(vertex)) 
        {
            // 排除当前节点的前置节点，因为是无向图，所以要避免往回走
            if(neighbor != pred) 
            {  
                // 发现已经被访问过的节点，形成了环
                if(visited[neighbor] == 1) 
                    return true;
                // 对未被访问过的节点进行递归
                else if(visited[neighbor] == 0) 
                {
                    if(hasCycle(vertex, neighbor, visited, adjList)) 
                        return true;
                }
            }
        }
        return false;
    }
}
