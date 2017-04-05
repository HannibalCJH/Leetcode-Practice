public class Solution {
    public bool ValidTree(int n, int[,] edges) 
    {
        List<int>[] adjList = new List<int>[n];
        // 初始化邻接链表
        for(int i = 0; i < n; i++)
            adjList[i] = new List<int>();
        // 构建无向图
        for(int i = 0; i < edges.GetLength(0); i++)
        {
            adjList[edges[i, 0]].Add(edges[i, 1]);
            adjList[edges[i, 1]].Add(edges[i, 0]);
        }
        
        bool[] visited = new bool[n];
        // 有环
        if(HasCycle(adjList, -1, 0, visited))
            return false;
        // 是否还有节点没有被访问到
        for(int i = 0; i < n; i++)
            if(!visited[i])
                return false;
        return true;
    }
    
    private bool HasCycle(List<int>[] adjList, int pre, int cur, bool[] visited)
    {
        List<int> nextList = adjList[cur];
        visited[cur] = true;
        foreach(int next in nextList)
        {
            if(next != pre)
            {
                if(visited[next] || HasCycle(adjList, cur, next, visited))
                    return true;
            }
        }
        return false;
    }
}
