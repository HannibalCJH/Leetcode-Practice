public class Solution {
    // 时间复杂度O(kmn)，k为0的个数
    // 空间复杂度O(max(m,n))
    public void wallsAndGates(int[][] rooms) 
    {
        for(int i = 0; i < rooms.length; i++)
        {
            for(int j = 0; j < rooms[0].length; j++)
            {
                // 从每个门开始向四周搜索
                if(rooms[i][j] == 0)
                    dfs(rooms, i, j, 0);
            }
        }
    }
    
    private void dfs(int[][] rooms, int x, int y, int distance)
    {
        // 越界或是当前格子到这个门的距离比rooms[x][y]的值大，有两种可能
        // 1. 撞到了墙，distance肯定是大于0的，墙是-1，所以撞到墙时肯定满足rooms[x][y] < distance直接返回
        // 2. 之前遍历过的其他门，所以这个格子到之前的门的距离更短，我们要搜索的是最近的门，所以当前的门不是离这个格子最近的就返回
        if(x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] < distance)
            return;
        
        // 更新这个格子的到当前门的距离
        rooms[x][y] = distance;
        dfs(rooms, x - 1, y, distance + 1);
        dfs(rooms, x + 1, y, distance + 1);
        dfs(rooms, x, y - 1, distance + 1);
        dfs(rooms, x, y + 1, distance + 1);
    }
}
