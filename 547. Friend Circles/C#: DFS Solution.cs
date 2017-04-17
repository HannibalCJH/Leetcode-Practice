public class Solution {
    public int FindCircleNum(int[,] M) 
    {
        if(M == null || M.GetLength(0) == 0 || M.GetLength(1) == 0)
            return 0;
        
        int n = M.GetLength(0), count = 0;
        bool[] visited = new bool[n];
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                DFS(M, i, visited);
                count++;
            }
        }
        return count;
    }
    
    private void DFS(int[,] M, int cur, bool[] visited)
    {
        if(visited[cur])
            return;
        
        visited[cur] = true;
        for(int i = 0; i < M.GetLength(0); i++)
        {
            if(i == cur)
                continue;
            if(M[cur, i] == 1)
                DFS(M, i, visited);
        }
    }
}
