public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(max(m, n))看递归栈的空间
    public int numIslands(char[][] grid) 
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int num = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    num++;
                }
        return num;
    }
    
    private void dfs(char[][] grid, int x, int y)
    {
        // 越界或遇到'0'
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0')
            return;
        // 访问过的设为'0'
        grid[x][y] = '0';
        // 朝四个方向走
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
