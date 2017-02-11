public class Solution {
    public int NumIslands(char[,] grid) 
    {
        if(grid == null || grid.GetLength(0) == 0 || grid.GetLength(1) == 0)
            return 0;
        int num = 0;
        int m = grid.GetLength(0), n = grid.GetLength(1);
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i,j] == '1')
                {
                    DFS(grid, i, j);
                    num++;
                }
        return num;
    }
    
    private void DFS(char[,] grid, int x, int y)
    {
        if(x < 0 || y < 0 || x >= grid.GetLength(0) || y >= grid.GetLength(1) || grid[x,y] == '0')
            return;
            
        grid[x,y] = '0';
        DFS(grid, x - 1, y);
        DFS(grid, x + 1, y);
        DFS(grid, x, y + 1);
        DFS(grid, x, y - 1);
    }
}
