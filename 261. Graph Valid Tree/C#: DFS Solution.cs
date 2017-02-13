public class Solution {
    public bool ValidTree(int n, int[,] edges) 
    {
        int[] visited = new int[n];
        List<List<int>> adjList = new List<List<int>>(n);
        // 初始化邻接表
        for(int i = 0; i < n; i++)
            adjList.Add(new List<int>());
        for(int i = 0; i < edges.GetLength(0); i++)
        {
            adjList[edges[i,0]].Add(edges[i,1]);
            adjList[edges[i,1]].Add(edges[i,0]);
        }
        
        if(HasCycle(-1, 0, visited, adjList))
            return false;
        foreach(int v in visited)
        {
            if(v == 0)
                return false;
        }
        return true;
    }
    
    private bool HasCycle(int preNode, int curNode, int[] visited, List<List<int>> adjList)
    {
        visited[curNode] = 1;
        foreach(int nextNode in adjList[curNode])
        {
            // 不往回走
            if(nextNode != preNode)
            {
                if(visited[nextNode] == 1)
                    return true;
                else if(visited[nextNode] == 0)
                {
                    if(HasCycle(curNode, nextNode, visited, adjList))
                    return true;
                }
            }
        }
        return false;
    }
}
